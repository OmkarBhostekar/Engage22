package com.omkarcodes.movee.data;

import java.lang.System;

@androidx.room.Database(entities = {com.omkarcodes.movee.models.Movie.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/omkarcodes/movee/data/MoveeDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getDao", "Lcom/omkarcodes/movee/ui/saved/MoveeDao;", "app_debug"})
public abstract class MoveeDatabase extends androidx.room.RoomDatabase {
    
    public MoveeDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.omkarcodes.movee.ui.saved.MoveeDao getDao();
}