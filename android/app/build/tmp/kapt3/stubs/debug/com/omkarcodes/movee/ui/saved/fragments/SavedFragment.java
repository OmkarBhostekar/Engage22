package com.omkarcodes.movee.ui.saved.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/omkarcodes/movee/ui/saved/fragments/SavedFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/omkarcodes/movee/ui/saved/adapters/SavedAdapter$OnClickListener;", "()V", "_binding", "Lcom/omkarcodes/movee/databinding/FragmentSavedBinding;", "binding", "getBinding", "()Lcom/omkarcodes/movee/databinding/FragmentSavedBinding;", "savedViewModel", "Lcom/omkarcodes/movee/ui/saved/SavedViewModel;", "getSavedViewModel", "()Lcom/omkarcodes/movee/ui/saved/SavedViewModel;", "savedViewModel$delegate", "Lkotlin/Lazy;", "onClick", "", "s", "Lcom/omkarcodes/movee/models/Movie;", "Lcom/omkarcodes/movee/databinding/ItemSearchBinding;", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SavedFragment extends androidx.fragment.app.Fragment implements com.omkarcodes.movee.ui.saved.adapters.SavedAdapter.OnClickListener {
    private com.omkarcodes.movee.databinding.FragmentSavedBinding _binding;
    private final kotlin.Lazy savedViewModel$delegate = null;
    
    public SavedFragment() {
        super();
    }
    
    private final com.omkarcodes.movee.databinding.FragmentSavedBinding getBinding() {
        return null;
    }
    
    private final com.omkarcodes.movee.ui.saved.SavedViewModel getSavedViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.models.Movie s, @org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.databinding.ItemSearchBinding binding) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}