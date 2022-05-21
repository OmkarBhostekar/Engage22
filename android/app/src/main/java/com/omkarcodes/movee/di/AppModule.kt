package com.omkarcodes.movee.di

import android.content.Context
import androidx.room.Room
import com.omkarcodes.movee.data.MoveeDatabase
import com.omkarcodes.movee.ui.detail.DetailApi
import com.omkarcodes.movee.ui.home.HomeApi
import com.omkarcodes.movee.ui.search.SearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    fun provideRetrofit2(client: OkHttpClient) : Retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org/")
        .build()

    @Provides
    fun provideMoveeApi(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)

    @Provides
    fun provideDetailApi(retrofit: Retrofit) : DetailApi = retrofit.create(DetailApi::class.java)

    @Provides
    fun provideSearchApi(retrofit: Retrofit) : SearchApi = retrofit.create(SearchApi::class.java)


    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MoveeDatabase = Room.databaseBuilder(
            context,
            MoveeDatabase::class.java,
            "movve_db"
    ).build()

    @Provides
    fun provideDao(db: MoveeDatabase) = db.getDao()

    @Provides
    fun provideOwnerName() =  "Omkar"
}