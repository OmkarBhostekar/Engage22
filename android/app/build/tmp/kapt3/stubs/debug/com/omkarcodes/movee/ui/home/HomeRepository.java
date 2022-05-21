package com.omkarcodes.movee.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\f0\u000b0\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\f0\u000b0\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/omkarcodes/movee/ui/home/HomeRepository;", "", "api", "Lcom/omkarcodes/movee/ui/home/HomeApi;", "(Lcom/omkarcodes/movee/ui/home/HomeApi;)V", "apiKey", "", "getApiKey", "()Ljava/lang/String;", "getMcuMovies", "Lretrofit2/Response;", "Lcom/omkarcodes/movee/models/PagingWrapper;", "", "Lcom/omkarcodes/movee/ui/home/models/PopularMovie;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNetflixOg", "Lcom/omkarcodes/movee/ui/home/models/NetflixOg;", "getNowPlayingMovies", "getPopularMovies", "getPopularTvShows", "app_debug"})
public final class HomeRepository {
    private final com.omkarcodes.movee.ui.home.HomeApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = "5e08ba1c1a1dcf7f83c837a7b9db7776";
    
    @javax.inject.Inject()
    public HomeRepository(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.home.HomeApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNetflixOg(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.omkarcodes.movee.models.PagingWrapper<java.util.List<com.omkarcodes.movee.ui.home.models.NetflixOg>>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPopularMovies(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.omkarcodes.movee.models.PagingWrapper<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNowPlayingMovies(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.omkarcodes.movee.models.PagingWrapper<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMcuMovies(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.omkarcodes.movee.models.PagingWrapper<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPopularTvShows(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.omkarcodes.movee.models.PagingWrapper<java.util.List<com.omkarcodes.movee.ui.home.models.NetflixOg>>>> continuation) {
        return null;
    }
}