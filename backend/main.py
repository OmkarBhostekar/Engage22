from fastapi import FastAPI, HTTPException, Response
import joblib
import pandas as pd
import pandas as pd

movies = pd.read_csv('dataset/movies.csv')
movies = movies.fillna('')
movies = movies[['movieId','tmdbId','title','poster_path','backdrop_path']]
moviesDict = movies.to_dict(orient='records')

app = FastAPI()

allGenres = joblib.load('model/genres.joblib')


# Urls
@app.get("/movie/top-rated")
def get_top_rated():
    res = get_highly_rated()
    return res

@app.get("/movie/content-recommendation")
def get_content_based(tmdbId):
    if int(tmdbId) not in movies['tmdbId'].values:
        raise HTTPException(status_code=404, detail="Item not found")
    res = getContentBasedRecommendation(int(tmdbId))
    return res

@app.get("/movie/cf-recommendation")
def get_cf_based(movieId):
    if int(movieId) not in movies['movieId']:
        raise HTTPException(status_code=404, detail="Item not found")
    res = getCfRecommendations(int(movieId))
    return res

@app.get('/movie/genres')
def get_genres():
    return allGenres

# Helper Functions

'''
<============== top rated recommendations ==============>
'''

popular_movies = joblib.load('model/top_rated.joblib')

def get_highly_rated():
    return Response(popular_movies.to_json(orient="records"), media_type="application/json")
    
'''
<============== content based recommendations ==============>
'''

movieDf = joblib.load('model/movie_df.joblib')
similarity = joblib.load('model/content_based.joblib')

def getContentBasedRecommendation(tmdbId):
    idx = movieDf[movieDf['tmdbId'] == int(tmdbId)].index[0]
    distances = similarity[idx]
    movies_list = sorted(list(enumerate(distances)),reverse=True,key=lambda x:x[1])[1:11]
    L = []
    for i in movies_list:
        L.append(moviesDict[i[0]])
    print(type(L))
    return L

item_genre_mat = joblib.load('model/item_genre_mat.joblib')

def top_k_items(item_id, top_k, corr_mat, map_name):
    # sort correlation value ascendingly and select top_k item_id
    top_items = corr_mat[item_id,:].argsort()[-top_k:][::-1] 
    top_items = [map_name[e] for e in top_items] 

    return top_items

# get top-k similar items
ind2name = {ind:name for ind,name in enumerate(item_genre_mat.index)}
name2ind = {v:k for k,v in ind2name.items()}


'''
<============== Collaborative filtering recommendations ==============>
'''

funk_mat = joblib.load('model/funk_model.joblib')

def getCfRecommendations(movieId):
    similar_items = top_k_items(name2ind[movieId],
                            top_k = 10,
                            corr_mat = funk_mat,
                            map_name = ind2name)
    if(movieId in similar_items):
        similar_items.remove(int(movieId))

    res = movies.loc[movies['movieId'].isin(similar_items)]
    return Response(res.to_json(orient="records"), media_type="application/json")