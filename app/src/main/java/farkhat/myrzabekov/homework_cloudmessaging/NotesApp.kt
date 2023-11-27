package farkhat.myrzabekov.homework_cloudmessaging

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import farkhat.myrzabekov.homework_cloudmessaging.di.appModule
import farkhat.myrzabekov.homework_cloudmessaging.di.viewModelModule

class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NotesApp)
            modules(listOf(appModule, viewModelModule))
        }
    }
}
