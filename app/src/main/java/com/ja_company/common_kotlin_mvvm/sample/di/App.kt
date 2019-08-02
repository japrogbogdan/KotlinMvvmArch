package com.ja_company.common_kotlin_mvvm.sample.di

import com.ja_company.common_kotlin_mvvm.library.MvvmApplication
import org.koin.core.module.Module

class App: MvvmApplication() {

    override val modules: ArrayList<Module>
        get() = arrayListOf(appModule)
}