package com.google.bus_schedule

import android.app.Application
import com.google.bus_schedule.database.schedule.AppDatabase

class BusScheduleApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}