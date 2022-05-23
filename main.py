from cmath import log
from fastapi import FastAPI, BackgroundTasks, File, Response, UploadFile
from fastapi.middleware.cors import CORSMiddleware
from pymongo import MongoClient
import pandas as pd
import json
import uuid
from bson import json_util
from typing import List
import requests
import numpy as np
import os
import time
import pandas as pd
import numpy as np
from zipfile import ZipFile
import tensorflow as tf
from tensorflow import keras
from pathlib import Path
import matplotlib.pyplot as plt
import os
import tempfile
from sklearn.metrics.pairwise import cosine_similarity


app = FastAPI()

ratings = pd.read_csv('model/ratings.csv')
movies = pd.read_csv('model/movies.csv')
tags = pd.read_csv('model/tags.csv')
ids = pd.read_csv('model/links.csv')
movies = movies.merge(ids,on='movieId')
movies['genres'] = movies['genres'].apply(lambda x: x.replace('|',','))

# extract the genre
genre = movies['genres'].str.split(",", expand=True)

# get all possible genre
all_genre = set()
for c in genre.columns:
    distinct_genre = genre[c].str.lower().str.strip().unique()
    all_genre.update(distinct_genre)
all_genre.remove(None)
all_genre.remove('(no genres listed)')
allGenres = []
for i in all_genre:
    allGenres.append(i)


# Urls
@app.get("/movie/top-rated")
def get_top_rated():
    res = get_highly_rated(ratings,movies)
    return res

@app.get("/movie/content-recommendation")
def get_top_rated(movieId):
    res = getContentBasedRecommendation(int(movieId))
    return res

@app.get('/movie/genres')
def get_genres():
    return allGenres

# Helper Functions

def weighted_rating(v,m,R,C):
    return ( (v / (v + m)) * R) + ( (m / (v + m)) * C )

'''
<============== top rated recommendations ==============>
'''
def get_highly_rated(rating_df, item_df):
    # pre processing
    vote_count = (
        rating_df
        .groupby('movieId',as_index=False)
        .agg( {'userId':'count', 'rating':'mean'} )
        )
    vote_count.columns = ['movieId', 'vote_count', 'avg_rating']
    
    # calcuate input parameters
    C = np.mean(vote_count['avg_rating'])
    m = np.percentile(vote_count['vote_count'], 70)
    vote_count = vote_count[vote_count['vote_count'] >= m]
    R = vote_count['avg_rating']
    v = vote_count['vote_count']
    vote_count['weighted_rating'] = weighted_rating(v,m,R,C)
    
    # post processing
    vote_count = vote_count.merge(item_df, on = ['movieId'], how = 'left')
    popular_movies = vote_count.loc[:,['movieId', 'vote_count', 'avg_rating', 'weighted_rating']]
    popular_movies = popular_movies.sort_values('weighted_rating',ascending=False)
    popular_movies = popular_movies.head(10)
    popular_movies = popular_movies.merge(movies,left_on='movieId',right_on='movieId')

    return Response(popular_movies.to_json(orient="records"), media_type="application/json")
    
'''
<============== content based recommendations ==============>
'''
# create item-genre matrix
item_genre_mat = movies[['movieId', 'genres']].copy()
item_genre_mat['genres'] = item_genre_mat['genres'].str.lower().str.strip()

# OHE the genres column
for genre in all_genre:
    item_genre_mat[genre] = np.where(item_genre_mat['genres'].str.contains(genre), 1, 0)
item_genre_mat = item_genre_mat.drop(['genres'], axis=1)
item_genre_mat = item_genre_mat.set_index('movieId')

# compute similarity matix
corr_mat = cosine_similarity(item_genre_mat)

def top_k_items(item_id, top_k, corr_mat, map_name):
    # sort correlation value ascendingly and select top_k item_id
    top_items = corr_mat[item_id,:].argsort()[-top_k:][::-1] 
    top_items = [map_name[e] for e in top_items] 

    return top_items

# get top-k similar items
ind2name = {ind:name for ind,name in enumerate(item_genre_mat.index)}
name2ind = {v:k for k,v in ind2name.items()}

def getContentBasedRecommendation(movieId):
    similar_items = top_k_items(name2ind[movieId],
                            top_k = 10,
                            corr_mat = corr_mat,
                            map_name = ind2name)
    if(movieId in similar_items):
        similar_items.remove(int(movieId))
    res = movies.loc[movies['movieId'].isin(similar_items)]
    return Response(res.to_json(orient="records"), media_type="application/json")
