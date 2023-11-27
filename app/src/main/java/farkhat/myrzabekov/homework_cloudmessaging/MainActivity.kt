package farkhat.myrzabekov.homework_cloudmessaging

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import farkhat.myrzabekov.homework_cloudmessaging.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import farkhat.myrzabekov.homework_cloudmessaging.domain.model.Note
import farkhat.myrzabekov.homework_cloudmessaging.presentation.NoteViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupAddNoteButton()
    }

    private fun setupObservers() {
        viewModel.notes.asLiveData().observe(this) { notes ->
            Log.d("MainActivity", "Observing notes: $notes")
            binding.textViewNotes.text = notes.joinToString("\n") { note ->
                "${note.title}: ${note.content}"
            }
        }
    }

    private fun setupAddNoteButton() {
        binding.buttonAddNote.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val content = binding.editTextContent.text.toString()
            if (title.isNotBlank() && content.isNotBlank()) {
                val newNote = Note(title = title, content = content, timestamp = System.currentTimeMillis())
                viewModel.addNote(newNote)
                binding.editTextTitle.text.clear()
                binding.editTextContent.text.clear()
            }
        }
    }
}
