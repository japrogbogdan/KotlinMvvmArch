package com.ja_company.common_kotlin_mvvm.sample.ui

import android.os.Bundle
import com.bohdan.common_kotlin_mvvm.ui.activity.MvvmToolbarActivity
import com.ja_company.common_kotlin_mvvm.R
import com.ja_company.common_kotlin_mvvm.sample.navigation.AppActivitiesNavigator
import com.ja_company.common_kotlin_mvvm.sample.navigation.MainActivityFragmentNavigator
import com.ja_company.common_kotlin_mvvm.sample.ui.oneFragment.OneFragment
import com.ja_company.common_kotlin_mvvm.sample.ui.twoFragment.TwoFragment

class MainActivity : MvvmToolbarActivity<MainToolbarWrapper, MainActivityFragmentNavigator, AppActivitiesNavigator>(
    MainToolbarWrapper::class, MainActivityFragmentNavigator::class, AppActivitiesNavigator::class
), OneFragment.OneFragmentCommander, TwoFragment.TwoFragmentCommander, MainToolbarWrapper.MainToolbarCommander {

    override val containerResId: Int get() = R.id.main_container_view

    override val layoutResId: Int get() = R.layout.activity_main

    override val toolbarContainerResId: Int get() = R.id.main_toolbar_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        openOneFragment()
    }

    override fun setToolbarTitle(title: String) {
        toolbarWrapper.setToolbarTitle(title)
    }

    override fun setToolbarTitle(titleResId: Int) {
        toolbarWrapper.setToolbarTitle(titleResId)
    }

    override fun showProgressDialog() {}

    override fun hideProgressDialog() {}

    override fun openOneFragment() {
        fragmentNavigator.openOneFragment()
    }

    override fun openTwoFragment() {
        fragmentNavigator.openTwoFragment()
    }
}
