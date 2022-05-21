package com.omkarcodes.movee.ui.home.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0015\u0016B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/omkarcodes/movee/ui/home/adapters/MoviesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/omkarcodes/movee/ui/home/adapters/MoviesAdapter$ViewHolder;", "list", "", "Lcom/omkarcodes/movee/ui/home/models/PopularMovie;", "listener", "Lcom/omkarcodes/movee/ui/home/adapters/MoviesAdapter$OnMovieClick;", "type", "", "(Ljava/util/List;Lcom/omkarcodes/movee/ui/home/adapters/MoviesAdapter$OnMovieClick;Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnMovieClick", "ViewHolder", "app_debug"})
public final class MoviesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.omkarcodes.movee.ui.home.adapters.MoviesAdapter.ViewHolder> {
    private final java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie> list = null;
    private final com.omkarcodes.movee.ui.home.adapters.MoviesAdapter.OnMovieClick listener = null;
    private final java.lang.String type = null;
    
    public MoviesAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.omkarcodes.movee.ui.home.models.PopularMovie> list, @org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.home.adapters.MoviesAdapter.OnMovieClick listener, @org.jetbrains.annotations.NotNull()
    java.lang.String type) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.omkarcodes.movee.ui.home.adapters.MoviesAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.home.adapters.MoviesAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/omkarcodes/movee/ui/home/adapters/MoviesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/omkarcodes/movee/databinding/ItemMovieBinding;", "(Lcom/omkarcodes/movee/ui/home/adapters/MoviesAdapter;Lcom/omkarcodes/movee/databinding/ItemMovieBinding;)V", "bind", "", "position", "", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.omkarcodes.movee.databinding.ItemMovieBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.databinding.ItemMovieBinding binding) {
            super(null);
        }
        
        public final void bind(int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/omkarcodes/movee/ui/home/adapters/MoviesAdapter$OnMovieClick;", "", "onClick", "", "movie", "Lcom/omkarcodes/movee/ui/home/models/PopularMovie;", "type", "", "binding", "Lcom/omkarcodes/movee/databinding/ItemMovieBinding;", "app_debug"})
    public static abstract interface OnMovieClick {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.ui.home.models.PopularMovie movie, @org.jetbrains.annotations.NotNull()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.databinding.ItemMovieBinding binding);
    }
}