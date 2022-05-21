package com.omkarcodes.movee.ui.detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u0015\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/omkarcodes/movee/ui/detail/DetailRepository;", "", "api", "Lcom/omkarcodes/movee/ui/detail/DetailApi;", "dao", "Lcom/omkarcodes/movee/ui/saved/MoveeDao;", "(Lcom/omkarcodes/movee/ui/detail/DetailApi;Lcom/omkarcodes/movee/ui/saved/MoveeDao;)V", "getCredits", "Lretrofit2/Response;", "Lcom/omkarcodes/movee/ui/detail/models/tv/CastResponse;", "type", "", "id", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieDetail", "Lcom/omkarcodes/movee/ui/detail/models/movie/MovieDetail;", "movieId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTvDetail", "Lcom/omkarcodes/movee/ui/detail/models/tv/TvDetail;", "tvId", "insertMovie", "", "movie", "Lcom/omkarcodes/movee/models/Movie;", "app_debug"})
public final class DetailRepository {
    private final com.omkarcodes.movee.ui.detail.DetailApi api = null;
    private final com.omkarcodes.movee.ui.saved.MoveeDao dao = null;
    
    @javax.inject.Inject()
    public DetailRepository(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.detail.DetailApi api, @org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.saved.MoveeDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMovieDetail(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.omkarcodes.movee.ui.detail.models.movie.MovieDetail>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTvDetail(int tvId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.omkarcodes.movee.ui.detail.models.tv.TvDetail>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCredits(@org.jetbrains.annotations.NotNull()
    java.lang.String type, int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.omkarcodes.movee.ui.detail.models.tv.CastResponse>> continuation) {
        return null;
    }
    
    public final void insertMovie(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.models.Movie movie) {
    }
}