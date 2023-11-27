package farkhat.myrzabekov.homework_cloudmessaging.domain.usecase

import farkhat.myrzabekov.homework_cloudmessaging.domain.repository.NoteRepository
import farkhat.myrzabekov.homework_cloudmessaging.domain.model.Note

class GetNoteByIdUseCase(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id: Int): Note? {
        return noteRepository.getNoteById(id)
    }
}