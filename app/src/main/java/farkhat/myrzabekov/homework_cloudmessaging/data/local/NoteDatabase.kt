package farkhat.myrzabekov.homework_cloudmessaging.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import farkhat.myrzabekov.homework_cloudmessaging.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        fun create(context: Context): NoteDatabase {
            return Room.databaseBuilder(context, NoteDatabase::class.java, "notes.db")
                .build()
        }
    }
}
