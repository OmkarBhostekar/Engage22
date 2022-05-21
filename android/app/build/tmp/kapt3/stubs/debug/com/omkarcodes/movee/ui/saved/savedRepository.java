package com.omkarcodes.movee.ui.saved;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/omkarcodes/movee/ui/saved/savedRepository;", "", "dao", "Lcom/omkarcodes/movee/ui/saved/MoveeDao;", "(Lcom/omkarcodes/movee/ui/saved/MoveeDao;)V", "getDao", "()Lcom/omkarcodes/movee/ui/saved/MoveeDao;", "deleteMovie", "", "movie", "Lcom/omkarcodes/movee/models/Movie;", "getSaved", "Landroidx/lifecycle/LiveData;", "", "app_debug"})
public final class savedRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.omkarcodes.movee.ui.saved.MoveeDao dao = null;
    
    @javax.inject.Inject()
    public savedRepository(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.ui.saved.MoveeDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.omkarcodes.movee.ui.saved.MoveeDao getDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.omkarcodes.movee.models.Movie>> getSaved() {
        return null;
    }
    
    public final void deleteMovie(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.models.Movie movie) {
    }
}