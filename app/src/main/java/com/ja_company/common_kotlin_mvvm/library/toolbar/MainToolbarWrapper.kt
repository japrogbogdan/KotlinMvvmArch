package com.ja_company.common_kotlin_mvvm.library.toolbar

import com.ja_company.common_kotlin_mvvm.R
import com.ja_company.common_kotlin_mvvm.library.ui.activity.MvvmToolbarActivity

class MainToolbarWrapper(activity: MvvmToolbarActivity<*, *, *>) : TitleToolbarWrapper(activity) {

    override val titleViewResId: Int get() = R.id.title_view

    override val layoutResId: Int get() = R.layout.main_toolbar_layout

    interface MainToolbarCommander: TitleToolbarCommander
}