package com.ja_company.common_kotlin_mvvm.sample.di

import com.bohdan.common_kotlin_mvvm.MvvmApplication
import org.koin.core.module.Module

class App: MvvmApplication() {

    override val modules: ArrayList<Module>
        get() = arrayListOf(appModule)
}