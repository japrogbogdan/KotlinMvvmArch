package com.ja_company.common_kotlin_mvvm.library.ui.viewModel

interface MVVMLifecycleInterface {

    fun onAttach()

    fun onCreate()

    fun onActivityCreated()

    fun onViewReady()

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroyView()

    fun onDestroy()

    fun onDetach()
}