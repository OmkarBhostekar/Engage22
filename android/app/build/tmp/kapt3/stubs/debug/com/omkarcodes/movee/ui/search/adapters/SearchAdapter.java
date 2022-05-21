package com.omkarcodes.movee.ui.search.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0012\u0013\u0014B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/omkarcodes/movee/ui/search/adapters/SearchAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lcom/omkarcodes/movee/ui/search/models/SearchResult;", "Lcom/omkarcodes/movee/ui/search/adapters/SearchAdapter$ViewHolder;", "listener", "Lcom/omkarcodes/movee/ui/search/adapters/SearchAdapter$OnClickListener;", "(Lcom/omkarcodes/movee/ui/search/adapters/SearchAdapter$OnClickListener;)V", "getListener", "()Lcom/omkarcodes/movee/ui/search/adapters/SearchAdapter$OnClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "OnClickListener", "ViewHolder", "app_debug"})
public final class SearchAdapter extends androidx.paging.PagingDataAdapter<com.omkarcodes.movee.ui.search.models.SearchResult, com.omkarcodes.movee.ui.search.adapters.SearchAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.omkarcodes.movee.ui.search.adapters.SearchAdapter.OnClickListener listener = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.omkarcodes.movee.ui.search.adapters.SearchAdapter.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.omkarcodes.movee.ui.search.models.SearchResult> SEARCH_COMPARATOR = null;
    
    public SearchAdapter(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.search.adapters.SearchAdapter.OnClickListener listener) {
        super(null, null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.omkarcodes.movee.ui.search.adapters.SearchAdapter.OnClickListener getListener() {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.search.adapters.SearchAdapter.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.omkarcodes.movee.ui.search.adapters.SearchAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/omkarcodes/movee/ui/search/adapters/SearchAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/omkarcodes/movee/databinding/ItemSearchBinding;", "(Lcom/omkarcodes/movee/ui/search/adapters/SearchAdapter;Lcom/omkarcodes/movee/databinding/ItemSearchBinding;)V", "bind", "", "search", "Lcom/omkarcodes/movee/ui/search/models/SearchResult;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.omkarcodes.movee.databinding.ItemSearchBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.databinding.ItemSearchBinding binding) {
            super(null);
        }
        
        @android.annotation.SuppressLint(value = {"SetTextI18n"})
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.ui.search.models.SearchResult search) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/omkarcodes/movee/ui/search/adapters/SearchAdapter$OnClickListener;", "", "onClick", "", "s", "Lcom/omkarcodes/movee/ui/search/models/SearchResult;", "binding", "Lcom/omkarcodes/movee/databinding/ItemSearchBinding;", "app_debug"})
    public static abstract interface OnClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.ui.search.models.SearchResult s, @org.jetbrains.annotations.NotNull()
        com.omkarcodes.movee.databinding.ItemSearchBinding binding);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/omkarcodes/movee/ui/search/adapters/SearchAdapter$Companion;", "", "()V", "SEARCH_COMPARATOR", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/omkarcodes/movee/ui/search/models/SearchResult;", "getSEARCH_COMPARATOR", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.omkarcodes.movee.ui.search.models.SearchResult> getSEARCH_COMPARATOR() {
            return null;
        }
    }
}