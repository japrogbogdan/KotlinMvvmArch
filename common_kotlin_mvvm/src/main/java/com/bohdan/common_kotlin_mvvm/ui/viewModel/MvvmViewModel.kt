package com.bohdan.common_kotlin_mvvm.ui.viewModel

import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.lang.Exception

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

    fun <T : Any> ioThenMain(work: suspend (() -> T), callback: ((T) -> Unit), errorBlock :(e: Exception) -> Unit = {}) {
        viewModelJob = CoroutineScope(parentJob + Dispatchers.Main).launch {
            withTimeout(45000) {
                try {
                    val data = CoroutineScope(parentJob + Dispatchers.IO).async rt@{
                        return@rt work()
                    }.await()
                    callback(data)
                } catch (e: Exception) { errorBlock.invoke(e)}
            }
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