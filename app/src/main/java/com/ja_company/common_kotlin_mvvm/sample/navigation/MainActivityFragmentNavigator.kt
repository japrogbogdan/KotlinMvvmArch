package com.ja_company.common_kotlin_mvvm.sample.navigation

import com.ja_company.common_kotlin_mvvm.library.navigation.MvvmFragmentNavigator
import com.ja_company.common_kotlin_mvvm.library.ui.activity.MvvmActivity
import com.ja_company.common_kotlin_mvvm.sample.ui.oneFragment.OneFragment
import com.ja_company.common_kotlin_mvvm.sample.ui.twoFragment.TwoFragment

class MainActivityFragmentNavigator(activity: MvvmActivity<*, *>) : MvvmFragmentNavigator(activity) {

    fun openOneFragment() {
        replaceTransaction(OneFragment.newInstance())
    }

    fun openTwoFragment() {
        replaceTransaction(TwoFragment.newInstance())
    }
}
