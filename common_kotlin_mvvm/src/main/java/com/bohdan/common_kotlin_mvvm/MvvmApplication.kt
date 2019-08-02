package com.bohdan.common_kotlin_mvvm

import android.app.Application
import androidx.annotation.CallSuper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

abstract class MvvmApplication : Application() {

    abstract val modules: ArrayList<Module>

    @CallSuper
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MvvmApplication)
            modules(modules.apply { /*can add library module*/ })
        }
    }
}