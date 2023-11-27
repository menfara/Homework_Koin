package farkhat.myrzabekov.homework_cloudmessaging.data.repository

import kotlinx.coroutines.flow.Flow
import farkhat.myrzabekov.homework_cloudmessaging.domain.model.Note
import farkhat.myrzabekov.homework_cloudmessaging.domain.repository.NoteRepository
import farkhat.myrzabekov.homework_cloudmessaging.data.local.NoteDao

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)

    override suspend fun insertNote(note: Note) = dao.insertNote(note)

    override suspend fun updateNote(note: Note) = dao.updateNote(note)

    override suspend fun deleteNote(note: Note) = dao.deleteNote(note)
}
