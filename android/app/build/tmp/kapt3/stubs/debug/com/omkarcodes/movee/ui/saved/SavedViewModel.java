package com.omkarcodes.movee.ui.saved;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/omkarcodes/movee/ui/saved/SavedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/omkarcodes/movee/ui/saved/savedRepository;", "(Lcom/omkarcodes/movee/ui/saved/savedRepository;)V", "deleteMovie", "Lkotlinx/coroutines/Job;", "movie", "Lcom/omkarcodes/movee/models/Movie;", "getSaved", "Landroidx/lifecycle/LiveData;", "", "app_debug"})
public final class SavedViewModel extends androidx.lifecycle.ViewModel {
    private final com.omkarcodes.movee.ui.saved.savedRepository repository = null;
    
    @javax.inject.Inject()
    public SavedViewModel(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.saved.savedRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.omkarcodes.movee.models.Movie>> getSaved() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteMovie(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.models.Movie movie) {
        return null;
    }
}