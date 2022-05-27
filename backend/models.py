import os
import numpy as np
import pandas as pd
import pickle
from sklearn.metrics.pairwise import cosine_similarity
from scipy.sparse import csr_matrix
import joblib

ratings = pd.read_csv('dataset/ratings.csv')
movies = pd.read_csv('dataset/movies.csv')

movies['genres'] = movies['genres'].apply(lambda x: x.replace('|',','))


'''
<============== content based recommendations ==============>
'''

# preprocessing
ratedMovies = movies.loc[movies['movieId'].isin(ratings['movieId'])].copy()
# extract the genre
genre = ratedMovies['genres'].str.split(",", expand=True)

# get all possible genre
all_genre = joblib.load('model/genres.joblib')

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

# dump matrix
f1 = open('model/corr_mat.pkl', 'wb')
pickle.dump(corr_mat, f1)
f1.close()
f2 = open('model/item_genre_mat.pkl', 'wb')
pickle.dump(item_genre_mat, f2)
f2.close()

# def top_k_items(item_id, top_k, corr_mat, map_name):
    
#     # sort correlation value ascendingly and select top_k item_id
#     top_items = corr_mat[item_id,:].argsort()[-top_k:][::-1] 
#     top_items = [map_name[e] for e in top_items] 

#     return top_items

'''
<============== collaborative filtering memory based recommendations ==============>
'''


NUM_USERS = 1010
NUM_MOVIES = 10000


# preprocess data
row = ratings['userId']
col = ratings['movieId']
data = ratings['rating']

# init user-item matrix
mat = csr_matrix((data, (row, col)))
mat.eliminate_zeros()

# calculate sparsity
sparsity = float(len(mat.nonzero()[0]))
sparsity /= (mat.shape[0] * mat.shape[1])
sparsity *= 100
print(f'Sparsity: {sparsity:4.2f}%. This means that {sparsity:4.2f}% of the user-item ratings have a value.')

# compute similarity
item_corr_mat = cosine_similarity(mat.T)


# dump matrix
f1 = open('model/cf_memory.pkl', 'wb')
pickle.dump(item_corr_mat, f1)
f1.close()