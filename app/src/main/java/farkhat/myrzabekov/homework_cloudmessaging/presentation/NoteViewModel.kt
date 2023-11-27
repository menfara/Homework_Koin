package farkhat.myrzabekov.homework_cloudmessaging.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import farkhat.myrzabekov.homework_cloudmessaging.domain.model.Note
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            getNotesUseCase().collect { listOfNotes ->
                Log.d("NoteViewModel", "Loaded notes: $listOfNotes")
                _notes.value = listOfNotes
            }
        }
    }


    fun getNoteById(id: Int) {
        // Assuming we want to expose a single note as a StateFlow
        // This is a placeholder for the actual StateFlow you would use
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            updateNoteUseCase(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase(note)
        }
    }
}
