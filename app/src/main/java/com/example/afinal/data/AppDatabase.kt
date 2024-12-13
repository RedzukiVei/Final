package com.example.afinal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Base de datos que incluye la tabla "scores"
@Database(entities = [Score::class], version = 1, exportSchema = false)

class AppDatabase : RoomDatabase() {

    abstract fun scoreDao(): ScoreDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Método para obtener una instancia única de la base de datos
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "scores_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}