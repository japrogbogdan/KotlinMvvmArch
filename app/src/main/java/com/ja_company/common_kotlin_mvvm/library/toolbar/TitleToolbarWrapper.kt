package com.ja_company.common_kotlin_mvvm.library.toolbar

import android.view.View
import android.widget.TextView
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.ja_company.common_kotlin_mvvm.library.ui.activity.MvvmToolbarActivity

abstract class TitleToolbarWrapper(activity: MvvmToolbarActivity<*, *, *>) : ToolbarWrapper(activity) {

    lateinit var titleView: TextView

    @get:IdRes
    protected abstract val titleViewResId: Int

    @CallSuper
    override fun findChildViews(rootView: View) {
        titleView = rootView.findViewById(titleViewResId)
    }

    open fun setToolbarTitle(title: String) {
        titleView.text = title
    }

    open fun setToolbarTitle(@StringRes titleResId: Int) {
        titleView.setText(titleResId)
    }

    interface TitleToolbarCommander : ToolbarCommander {
        fun setToolbarTitle(title: String)
        fun setToolbarTitle(@StringRes titleResId: Int)
    }
}