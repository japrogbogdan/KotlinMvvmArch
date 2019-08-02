package com.ja_company.common_kotlin_mvvm.library.toolbar

import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import com.ja_company.common_kotlin_mvvm.library.ui.activity.MvvmToolbarActivity

abstract class ToolbarWrapper(protected val activity: MvvmToolbarActivity<*, *, *>) {

    lateinit var rootView: View

    @get:LayoutRes
    protected abstract val layoutResId: Int

    init {
        inflateRootView()
        findChildViews(rootView)
    }

    abstract fun findChildViews(rootView: View)

    private fun inflateRootView() {
        rootView = (activity.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(layoutResId, null)
    }

    interface ToolbarCommander

    inline fun <reified Commander : ToolbarCommander> toolbarCommander(function: Commander.() -> Unit) {
        activity.let { if (it is Commander) function(it) }
    }
}