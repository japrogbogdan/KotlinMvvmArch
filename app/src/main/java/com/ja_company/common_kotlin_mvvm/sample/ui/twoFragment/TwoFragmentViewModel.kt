package com.ja_company.common_kotlin_mvvm.sample.ui.twoFragment

import android.util.Log
import com.bohdan.common_kotlin_mvvm.ui.viewModel.MvvmViewModel

class TwoFragmentViewModel : MvvmViewModel() {
    init {
        Log.d("ViewModel", "TwoFragmentViewModel init")
    }

    override fun onCleared() {
        Log.d("ViewModel", "TwoFragmentViewModel cleared")
        super.onCleared()
    }
}