package farkhat.myrzabekov.homework_cloudmessaging.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import farkhat.myrzabekov.homework_cloudmessaging.data.local.NoteDao
import farkhat.myrzabekov.homework_cloudmessaging.data.local.NoteDatabase
import farkhat.myrzabekov.homework_cloudmessaging.data.repository.NoteRepositoryImpl
import farkhat.myrzabekov.homework_cloudmessaging.domain.repository.NoteRepository
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.AddNoteUseCase
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.DeleteNoteUseCase
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.GetNoteByIdUseCase
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.GetNotesUseCase
import farkhat.myrzabekov.homework_cloudmessaging.domain.usecase.UpdateNoteUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext appContext: Context): NoteDatabase {
        return NoteDatabase.create(appContext)
    }

    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.noteDao()
    }

    @Singleton
    @Provides
    fun provideGetNotesUseCase(noteRepository: NoteRepository): GetNotesUseCase {
        return GetNotesUseCase(noteRepository)
    }

    @Singleton
    @Provides
    fun provideGetNoteByIdUseCase(noteRepository: NoteRepository): GetNoteByIdUseCase {
        return GetNoteByIdUseCase(noteRepository)
    }

    @Singleton
    @Provides
    fun provideAddNoteUseCase(noteRepository: NoteRepository): AddNoteUseCase {
        return AddNoteUseCase(noteRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateNoteUseCase(noteRepository: NoteRepository): UpdateNoteUseCase {
        return UpdateNoteUseCase(noteRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteNoteUseCase(noteRepository: NoteRepository): DeleteNoteUseCase {
        return DeleteNoteUseCase(noteRepository)
    }


}
