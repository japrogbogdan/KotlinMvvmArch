package com.ja_company.common_kotlin_mvvm.sample.ui.oneFragment

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bohdan.common_kotlin_mvvm.ui.viewModel.MvvmViewModel
import java.lang.Exception

class OneFragmentViewModel : MvvmViewModel() {

    val success = MutableLiveData<String>()

    init {
        Log.d("ViewModel", "OneFragmentViewModel init")

        ioThenMain({
            Log.d("ViewModel", "start doHardWork in io thread")
            doHardWork()
        }, {
            success.value = it
            Log.d("ViewModel", it)
        }, {
            Log.d("ViewModel", it.message)
        })
    }

    private fun doHardWork(): String {
        SystemClock.sleep(5000)
        throw Exception("401 error")
        return "doHardWork completed success"
    }

    override fun onCleared() {
        Log.d("ViewModel", "OneFragmentViewModel cleared")
        super.onCleared()
    }
}