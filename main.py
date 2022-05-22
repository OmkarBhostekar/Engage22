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

@app.get('/movie/genres')
def get_genres():
    return allGenres

# Helper Functions

def weighted_rating(v,m,R,C):
    return ( (v / (v + m)) * R) + ( (m / (v + m)) * C )

'''
    Based on user ratings top rated movies with good count of ratings and highest avg ratings will be returned
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