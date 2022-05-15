package edu.miu.quizapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Quiz::class],
    version = 1,
    exportSchema = true
)
abstract class QuizDB : RoomDatabase() {
    abstract fun getQuizDao(): QuizDAO

    // Build RoomDB
    companion object {
        // visible to other threads
        @Volatile
        private var instance: QuizDB? = null
        private val LOCK = Any()
//        buildDatabase
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context): QuizDB {
            return Room.databaseBuilder(
                context.applicationContext,
                QuizDB::class.java,
                "quizdatabase"
            ).build()
        }
    }

}