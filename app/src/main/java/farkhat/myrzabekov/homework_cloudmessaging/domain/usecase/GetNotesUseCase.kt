package farkhat.myrzabekov.homework_cloudmessaging.domain.usecase

import farkhat.myrzabekov.homework_cloudmessaging.domain.repository.NoteRepository
import farkhat.myrzabekov.homework_cloudmessaging.domain.model.Note
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(private val noteRepository: NoteRepository) {
    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getNotes()
    }
}