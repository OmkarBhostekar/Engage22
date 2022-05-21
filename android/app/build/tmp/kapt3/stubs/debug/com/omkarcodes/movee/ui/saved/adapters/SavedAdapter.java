package com.omkarcodes.movee.ui.saved.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0017\u0018B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/omkarcodes/movee/ui/saved/adapters/SavedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/omkarcodes/movee/ui/saved/adapters/SavedAdapter$ViewHolder;", "listener", "Lcom/omkarcodes/movee/ui/saved/adapters/SavedAdapter$OnClickListener;", "list", "", "Lcom/omkarcodes/movee/models/Movie;", "(Lcom/omkarcodes/movee/ui/saved/adapters/SavedAdapter$OnClickListener;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "getListener", "()Lcom/omkarcodes/movee/ui/saved/adapters/SavedAdapter$OnClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnClickListener", "ViewHolder", "app_debug"})
public final class SavedAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.omkarcodes.movee.ui.saved.adapters.SavedAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.omkarcodes.movee.ui.saved.adapters.SavedAdapter.OnClickListener listener = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.omkarcodes.movee.models.Movie> list = null;
    
    public SavedAdapter(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.saved.adapters.SavedAdapter.OnClickListener listener, @org.jetbrains.annotations.NotNull()
    java.util.List<com.omkarcodes.movee.models.Movie> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.omkarcodes.movee.ui.saved.adapters.SavedAdapter.OnClickListener getListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.omkarcodes.movee.models.Movie> getList() {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.saved.adapters.SavedAdapter.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.omkarcodes.movee.ui.saved.adapters.SavedAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/omkarcodes/movee/ui/saved/adapters/SavedAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/omkarcodes/movee/databinding/ItemSearchBinding;", "(Lcom/omkarcodes/movee/ui/saved/adapters/SavedAdapter;Lcom/omkarcodes/movee/databinding/ItemSearchBinding;)V", "bind", "", "movie", "Lcom/omkarcodes/movee/models/Movie;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.omkarcodes.movee.databinding.ItemSearchBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.databinding.ItemSearchBinding binding) {
            super(null);
        }
        
        @android.annotation.SuppressLint(value = {"SetTextI18n"})
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.models.Movie movie) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/omkarcodes/movee/ui/saved/adapters/SavedAdapter$OnClickListener;", "", "onClick", "", "s", "Lcom/omkarcodes/movee/models/Movie;", "binding", "Lcom/omkarcodes/movee/databinding/ItemSearchBinding;", "app_debug"})
    public static abstract interface OnClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.models.Movie s, @org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.databinding.ItemSearchBinding binding);
    }
}