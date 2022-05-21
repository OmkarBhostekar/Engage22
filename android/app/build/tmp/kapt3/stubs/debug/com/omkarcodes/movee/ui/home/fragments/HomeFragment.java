package com.omkarcodes.movee.ui.home.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u001a\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006&"}, d2 = {"Lcom/omkarcodes/movee/ui/home/fragments/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/omkarcodes/movee/ui/home/adapters/MoviesAdapter$OnMovieClick;", "Lcom/omkarcodes/movee/ui/home/adapters/BigPosterMoviesAdapter$OnMovieClick;", "()V", "_binding", "Lcom/omkarcodes/movee/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/omkarcodes/movee/databinding/FragmentHomeBinding;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "viewModel", "Lcom/omkarcodes/movee/ui/home/HomeViewModel;", "getViewModel", "()Lcom/omkarcodes/movee/ui/home/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initObservers", "", "onBigPosterClick", "movie", "Lcom/omkarcodes/movee/ui/home/models/NetflixOg;", "Lcom/omkarcodes/movee/databinding/ItemBigPosterMovieBinding;", "onClick", "Lcom/omkarcodes/movee/ui/home/models/PopularMovie;", "type", "Lcom/omkarcodes/movee/databinding/ItemMovieBinding;", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class HomeFragment extends androidx.fragment.app.Fragment implements com.omkarcodes.movee.ui.home.adapters.MoviesAdapter.OnMovieClick, com.omkarcodes.movee.ui.home.adapters.BigPosterMoviesAdapter.OnMovieClick {
    private com.omkarcodes.movee.databinding.FragmentHomeBinding _binding;
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject()
    public java.lang.String name;
    
    public HomeFragment() {
        super();
    }
    
    private final com.omkarcodes.movee.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    private final com.omkarcodes.movee.ui.home.HomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initObservers() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onBigPosterClick(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.home.models.NetflixOg movie, @org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.databinding.ItemBigPosterMovieBinding binding) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.home.models.PopularMovie movie, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.databinding.ItemMovieBinding binding) {
    }
}