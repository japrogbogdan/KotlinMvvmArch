package com.ja_company.common_kotlin_mvvm.sample.ui

import com.bohdan.common_kotlin_mvvm.toolbar.TitleToolbarWrapper
import com.bohdan.common_kotlin_mvvm.ui.activity.MvvmToolbarActivity
import com.ja_company.common_kotlin_mvvm.R

class MainToolbarWrapper(activity: MvvmToolbarActivity<*, *, *>) : TitleToolbarWrapper(activity) {

    override val titleViewResId: Int get() = R.id.title_view

    override val layoutResId: Int get() = R.layout.main_toolbar_layout

    interface MainToolbarCommander : TitleToolbarCommander
}