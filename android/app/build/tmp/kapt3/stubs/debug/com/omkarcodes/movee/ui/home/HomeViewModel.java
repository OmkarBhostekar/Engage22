package com.omkarcodes.movee.ui.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0015J\u0006\u0010\u000e\u001a\u00020\u0015J\u0006\u0010\u0010\u001a\u00020\u0015J\u0006\u0010\u0012\u001a\u00020\u0015J\u0006\u0010\u0014\u001a\u00020\u0015R#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/omkarcodes/movee/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/omkarcodes/movee/ui/home/HomeRepository;", "(Lcom/omkarcodes/movee/ui/home/HomeRepository;)V", "mcuMovies", "Landroidx/lifecycle/MutableLiveData;", "Lcom/omkarcodes/movee/models/Resource;", "", "Lcom/omkarcodes/movee/ui/home/models/PopularMovie;", "getMcuMovies", "()Landroidx/lifecycle/MutableLiveData;", "netflixOriginals", "Lcom/omkarcodes/movee/ui/home/models/NetflixOg;", "getNetflixOriginals", "nowPlayingMovies", "getNowPlayingMovies", "popularMovies", "getPopularMovies", "popularTvShows", "getPopularTvShows", "Lkotlinx/coroutines/Job;", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.omkarcodes.movee.ui.home.HomeRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.NetflixOg>>> netflixOriginals = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>> popularMovies = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>> nowPlayingMovies = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>> mcuMovies = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>> popularTvShows = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.home.HomeRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.NetflixOg>>> getNetflixOriginals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>> getPopularMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>> getNowPlayingMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>> getMcuMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.omkarcodes.movee.models.Resource<java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie>>> getPopularTvShows() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getNetflixOriginals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getPopularMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getNowPlayingMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getMcuMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getPopularTvShows() {
        return null;
    }
}