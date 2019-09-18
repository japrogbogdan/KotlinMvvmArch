package com.bohdan.common_kotlin_mvvm.ui.viewModel

import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

open class MvvmViewModel : ViewModel(), MVVMLifecycleInterface {

    protected var viewModelJob: Job? = null
    private val parentJob = Job()

    val showLoading = MutableLiveData<Unit>()
    val hideLoading = MutableLiveData<Unit>()

    fun showLoading() {
        showLoading.value = Unit
    }

    fun hideLoading() {
        hideLoading.value = Unit
    }

    fun io(work: suspend (() -> Unit)) {
        viewModelJob = CoroutineScope(parentJob + Dispatchers.IO).launch {
            work()
        }
    }

    fun <T : Any> ioThenMain(work: suspend (() -> T), callback: ((T) -> Unit)) {
        viewModelJob = CoroutineScope(parentJob + Dispatchers.Main).launch {
            val data = CoroutineScope(parentJob + Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }
    }

    override fun onAttach() {}

    override fun onCreate() {}

    override fun onActivityCreated() {}

    override fun onViewReady() {}

    override fun onStart() {}

    override fun onResume() {}

    override fun onPause() {}

    override fun onStop() {}

    override fun onDestroyView() {
        hideLoading()
    }

    override fun onDestroy() {}

    override fun onDetach() {}

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        viewModelJob?.cancel()
    }
}