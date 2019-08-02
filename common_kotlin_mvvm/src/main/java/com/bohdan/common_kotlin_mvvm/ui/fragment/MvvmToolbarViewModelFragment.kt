package com.bohdan.common_kotlin_mvvm.ui.fragment

import android.content.Context
import androidx.annotation.CallSuper
import com.bohdan.common_kotlin_mvvm.toolbar.ToolbarWrapper
import com.bohdan.common_kotlin_mvvm.ui.viewModel.MvvmViewModel
import kotlin.reflect.KClass

abstract class MvvmToolbarViewModelFragment<TC : ToolbarWrapper.ToolbarCommander, LI : MvvmViewModel>(
    liClazz: KClass<LI>
) : MvvmViewModelFragment<LI>(liClazz) {

    lateinit var toolbarCommander: TC

    override fun setupCommander(context: Context?) {
        super.setupCommander(context)
        toolbarCommander = context as TC
    }

    @CallSuper
    override fun onViewReady() {
        setupToolbar()
    }

    protected abstract fun setupToolbar()
}