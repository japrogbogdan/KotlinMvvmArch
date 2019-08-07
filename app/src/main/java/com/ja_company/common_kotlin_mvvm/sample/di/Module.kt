package com.ja_company.common_kotlin_mvvm.sample.di

import android.app.Activity
import com.bohdan.common_kotlin_mvvm.ui.activity.MvvmActivity
import com.bohdan.common_kotlin_mvvm.ui.activity.MvvmToolbarActivity
import com.ja_company.common_kotlin_mvvm.sample.navigation.AppActivitiesNavigator
import com.ja_company.common_kotlin_mvvm.sample.navigation.MainActivityFragmentNavigator
import com.ja_company.common_kotlin_mvvm.sample.ui.MainToolbarWrapper
import com.ja_company.common_kotlin_mvvm.sample.ui.oneFragment.OneFragmentViewModel
import com.ja_company.common_kotlin_mvvm.sample.ui.twoFragment.TwoFragmentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory { (activity: MvvmActivity<*, *>) -> MainActivityFragmentNavigator(activity) }

    factory { (activity: Activity) -> AppActivitiesNavigator(activity) }

    factory { (activity: MvvmToolbarActivity<*, *, *>) -> MainToolbarWrapper(activity) }

    viewModel { OneFragmentViewModel() }

    viewModel { TwoFragmentViewModel() }
}