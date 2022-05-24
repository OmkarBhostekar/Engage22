package com.omkarcodes.movee.ui.detail;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0019J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/omkarcodes/movee/ui/detail/DetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/omkarcodes/movee/ui/detail/DetailRepository;", "(Lcom/omkarcodes/movee/ui/detail/DetailRepository;)V", "cast", "Landroidx/lifecycle/MutableLiveData;", "Lcom/omkarcodes/movee/models/Resource;", "", "Lcom/omkarcodes/movee/ui/detail/models/tv/Cast;", "getCast", "()Landroidx/lifecycle/MutableLiveData;", "movieDetail", "Lcom/omkarcodes/movee/ui/detail/models/movie/MovieDetail;", "getMovieDetail", "tvDetail", "Lcom/omkarcodes/movee/ui/detail/models/tv/TvDetail;", "getTvDetail", "videos", "Lcom/omkarcodes/movee/ui/detail/models/video/Result;", "getVideos", "Lkotlinx/coroutines/Job;", "type", "", "id", "", "movieId", "tvId", "insertMovie", "movie", "Lcom/omkarcodes/movee/models/Movie;", "app_debug"})
public final class DetailViewModel extends androidx.lifecycle.ViewModel {
    private final com.omkarcodes.movee.ui.detail.DetailRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<com.omkarcodes.movee.ui.detail.models.movie.MovieDetail>> movieDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<com.omkarcodes.movee.ui.detail.models.tv.TvDetail>> tvDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.detail.models.tv.Cast>>> cast = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.detail.models.video.Result>>> videos = null;
    
    @javax.inject.Inject()
    public DetailViewModel(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.detail.DetailRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<com.omkarcodes.movee.ui.detail.models.movie.MovieDetail>> getMovieDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<com.omkarcodes.movee.ui.detail.models.tv.TvDetail>> getTvDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.detail.models.tv.Cast>>> getCast() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.detail.models.video.Result>>> getVideos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getMovieDetail(int movieId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getTvDetail(int tvId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getCast(@org.jetbrains.annotations.NotNull()
    java.lang.String type, int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getVideos(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertMovie(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.models.Movie movie) {
        return null;
    }
}