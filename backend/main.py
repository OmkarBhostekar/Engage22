from fastapi import FastAPI, HTTPException, Response
import pandas as pd
import pandas as pd
import numpy as np
import os
from sklearn.metrics.pairwise import cosine_similarity
import pickle
from zipfile import ZipFile

movies = pd.read_csv('dataset/movies.csv')

if not os.path.exists('model/genre.pkl'):
    # opening the zip file in READ mode
    with ZipFile('model/models.zip') as zf:
            zf.extractall('model/')
    print('done')

app = FastAPI()

f = open('model/genre.pkl', 'rb')
allGenres = pickle.load(f)
f.close()


# Urls
@app.get("/movie/top-rated")
def get_top_rated():
    res = get_highly_rated()
    return res

@app.get("/movie/content-recommendation")
def get_top_rated(movieId):
    if int(movieId) not in movies['movieId']:
        raise HTTPException(status_code=404, detail="Item not found")
    res = getContentBasedRecommendation(int(movieId))
    return res

@app.get("/movie/cf-recommendation")
def get_top_rated(movieId):
    if int(movieId) not in movies['movieId']:
        raise HTTPException(status_code=404, detail="Item not found")
    res = getContentBasedRecommendation(int(movieId))
    return res

@app.get('/movie/genres')
def get_genres():
    return allGenres

# Helper Functions

'''
<============== top rated recommendations ==============>
'''

f = open('model/top_rated.pkl', 'rb')
popular_movies = pickle.load(f)
f.close()

def get_highly_rated():
    return Response(popular_movies.to_json(orient="records"), media_type="application/json")
    
'''
<============== content based recommendations ==============>
'''

r = open('model/item_genre_mat.pkl', 'rb')
item_genre_mat = pickle.load(r)
r.close()
r2 = open('model/corr_mat.pkl', 'rb')
corr_matrix = pickle.load(r2)
r2.close()

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
                            corr_mat = corr_matrix,
                            map_name = ind2name)
    if(movieId in similar_items):
        similar_items.remove(int(movieId))
    res = movies.loc[movies['movieId'].isin(similar_items)]
    return Response(res.to_json(orient="records"), media_type="application/json")


'''
<============== content based recommendations ==============>
'''

r = open('model/cf_memory.pkl', 'rb')
movie_cf_mat = pickle.load(r)
r.close()

def getCfRecommendations(movieId):
    similar_items = top_k_items(name2ind[movieId],
                            top_k = 10,
                            corr_mat = movie_cf_mat,
                            map_name = ind2name)
    if(movieId in similar_items):
        similar_items.remove(int(movieId))
    res = movies.loc[movies['movieId'].isin(similar_items)]
    return Response(res.to_json(orient="records"), media_type="application/json")