package farkhat.myrzabekov.homework_cloudmessaging.domain.repository

import kotlinx.coroutines.flow.Flow
import farkhat.myrzabekov.homework_cloudmessaging.domain.model.Note

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
}