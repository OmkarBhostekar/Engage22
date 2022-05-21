package com.omkarcodes.movee.ui.saved;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\n"}, d2 = {"Lcom/omkarcodes/movee/ui/saved/MoveeDao;", "", "deleteMovie", "", "movie", "Lcom/omkarcodes/movee/models/Movie;", "getFav", "Landroidx/lifecycle/LiveData;", "", "insertMovie", "app_debug"})
public abstract interface MoveeDao {
    
    @androidx.room.Insert(entity = com.omkarcodes.movee.models.Movie.class, onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertMovie(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.models.Movie movie);
    
    @androidx.room.Delete(entity = com.omkarcodes.movee.models.Movie.class)
    public abstract void deleteMovie(@org.jetbrains.annotations.NotNull()
    com.omkarcodes.movee.models.Movie movie);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM movie ORDER BY addedOn DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.omkarcodes.movee.models.Movie>> getFav();
}