package farkhat.myrzabekov.homework_cloudmessaging.domain.usecase

import farkhat.myrzabekov.homework_cloudmessaging.domain.repository.NoteRepository
import farkhat.myrzabekov.homework_cloudmessaging.domain.model.Note

class UpdateNoteUseCase(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        noteRepository.updateNote(note)
    }
}