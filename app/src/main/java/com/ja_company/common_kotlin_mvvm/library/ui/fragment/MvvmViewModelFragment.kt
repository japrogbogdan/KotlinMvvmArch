package com.ja_company.common_kotlin_mvvm.library.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.ja_company.common_kotlin_mvvm.library.ui.viewModel.MvvmViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class MvvmViewModelFragment<LI : MvvmViewModel>(liClazz: KClass<LI>) : MvvmFragment() {

    val viewModel: LI by viewModel(liClazz, null, null)

    abstract val fragmentTag: String

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract fun onViewReady()

    @CallSuper
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel.onAttach()
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.onActivityCreated()
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewReady()
        onViewReady()
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        viewModel.onStop()
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.onDestroyView()
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    @CallSuper
    override fun onDetach() {
        super.onDetach()
        viewModel.onDetach()
    }
}