package com.example.covidstats.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.covidstats.model.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
abstract class CovidStatusDatabase : RoomDatabase() {

    abstract fun statusDao(): CovidStatusDao

    companion object {

        @Volatile
        private var INSTANCE: CovidStatusDatabase? = null

        fun getInstance(context: Context): CovidStatusDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CovidStatusDatabase::class.java,
                        "status_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}