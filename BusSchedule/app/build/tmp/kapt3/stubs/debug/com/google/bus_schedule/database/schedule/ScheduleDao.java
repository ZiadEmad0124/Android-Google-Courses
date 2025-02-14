package com.google.bus_schedule.database.schedule;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\t"}, d2 = {"Lcom/google/bus_schedule/database/schedule/ScheduleDao;", "", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/google/bus_schedule/database/schedule/Schedule;", "getByStopName", "stopName", "", "app_debug"})
@androidx.room.Dao
public abstract interface ScheduleDao {
    
    @androidx.room.Query(value = "SELECT * FROM schedule ORDER BY arrival_time ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.google.bus_schedule.database.schedule.Schedule>> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.google.bus_schedule.database.schedule.Schedule>> getByStopName(@org.jetbrains.annotations.NotNull
    java.lang.String stopName);
}