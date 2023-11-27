package farkhat.myrzabekov.homework_cloudmessaging.di

import android.content.Context
import androidx.room.Room
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import farkhat.myrzabekov.homework_cloudmessaging.data.local.NoteDao
import farkhat.myrzabekov.homework_cloudmessaging.data.local.NoteDatabase
import farkhat.myrzabekov.homework_cloudmessaging.data.repository.NoteRepositoryImpl
import farkhat.myrzabekov.homework_cloudmessaging.domain.repository.NoteRepository
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.AddNoteUseCase
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.DeleteNoteUseCase
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.GetNoteByIdUseCase
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.GetNotesUseCase
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.UpdateNoteUseCase
import farkhat.myrzabekov.homework_cloudmessaging.presentation.NoteViewModel

val appModule = module {

    single<NoteDatabase> { Room.databaseBuilder(get(), NoteDatabase::class.java, "notes.db").build() }

    single<NoteDao> { get<NoteDatabase>().noteDao() }

    single<NoteRepository> { NoteRepositoryImpl(get()) }

    factory { GetNotesUseCase(get()) }
    factory { GetNoteByIdUseCase(get()) }
    factory { AddNoteUseCase(get()) }
    factory { UpdateNoteUseCase(get()) }
    factory { DeleteNoteUseCase(get()) }
}

val viewModelModule = module {
    viewModel {
        NoteViewModel(
            getNotesUseCase = get(),
            getNoteByIdUseCase = get(),
            addNoteUseCase = get(),
            updateNoteUseCase = get(),
            deleteNoteUseCase = get()
        )
    }
}

