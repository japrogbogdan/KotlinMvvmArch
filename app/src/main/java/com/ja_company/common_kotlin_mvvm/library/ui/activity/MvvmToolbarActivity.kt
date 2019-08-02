package com.ja_company.common_kotlin_mvvm.library.ui.activity

import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.IdRes
import com.ja_company.common_kotlin_mvvm.library.navigation.MvvmActivitiesNavigator
import com.ja_company.common_kotlin_mvvm.library.navigation.MvvmFragmentNavigator
import com.ja_company.common_kotlin_mvvm.library.toolbar.ToolbarWrapper
import org.koin.android.ext.android.getKoin
import org.koin.core.parameter.parametersOf
import kotlin.reflect.KClass

abstract class MvvmToolbarActivity<TW : ToolbarWrapper, FN : MvvmFragmentNavigator, N : MvvmActivitiesNavigator>(
    val twClazz: KClass<TW>,
    fnClazz: KClass<FN>,
    nClazz: KClass<N>
) : MvvmActivity<FN, N>(fnClazz, nClazz) {

    lateinit var toolbarWrapper: TW

    @get:IdRes
    protected abstract val toolbarContainerResId: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toolbarWrapper = getKoin().get(twClazz, null) { parametersOf(this@MvvmToolbarActivity) }

        val toolbarContainer = findViewById<ViewGroup>(toolbarContainerResId)
        val toolbarRootView = toolbarWrapper.rootView
        toolbarContainer.addView(
            toolbarRootView, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }
}