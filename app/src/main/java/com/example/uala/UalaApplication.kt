package com.example.uala

import android.app.Application
import com.example.uala.di.ualaModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class UalaApplication : Application() {

    fun UalaApplication() {
        instance = this
    }
    companion object {
        private var instance: UalaApplication? = null
        fun getContext(): UalaApplication? {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()

        // start Koin context
        startKoin {
            androidContext(this@UalaApplication)
            androidLogger(Level.DEBUG)
            modules(ualaModule)
        }
    }
}