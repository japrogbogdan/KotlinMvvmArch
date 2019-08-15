package com.bohdan.common_kotlin_mvvm.navigation

import androidx.fragment.app.FragmentTransaction
import com.bohdan.common_kotlin_mvvm.R
import com.bohdan.common_kotlin_mvvm.ui.activity.MvvmActivity
import com.bohdan.common_kotlin_mvvm.ui.fragment.MvvmViewModelFragment

open class MvvmFragmentNavigator(protected val activity: MvvmActivity<*, *>) {

    fun replaceTransaction(fragment: MvvmViewModelFragment<*>) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(activity.containerResId, fragment, fragment.fragmentTag)
            .commitAllowingStateLoss()
    }

    protected fun replaceWithAnimationTransaction(fragment: MvvmViewModelFragment<*>) {
        activity
            .supportFragmentManager
            .beginTransaction()
            .applyDefaultNextCustomAnimations()
            .replace(activity.containerResId, fragment)
            .commitAllowingStateLoss()
    }

    protected fun replaceNextTransaction(fragment: MvvmViewModelFragment<*>) {
        activity
            .supportFragmentManager
            .beginTransaction()
            .applyDefaultNextCustomAnimations()
            .replace(activity.containerResId, fragment)
            .commitAllowingStateLoss()
    }

    protected fun replaceBackTransaction(fragment: MvvmViewModelFragment<*>) {
        val fragmentTransaction = activity
            .supportFragmentManager
            .beginTransaction()
            .applyDefaultBackCustomAnimations()
            .replace(activity.containerResId, fragment)
            .commitAllowingStateLoss()
    }

    protected fun addTransaction(fragment: MvvmViewModelFragment<*>, hideCurrent: Boolean = true) {
        val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
        fragmentTransaction.applyDefaultNextCustomAnimations()
            .add(activity.containerResId, fragment, fragment.fragmentTag)

        //todo improve
//        if (hideCurrent) activity.currentFragment?.let { fragmentTransaction.hide(it) }

        fragmentTransaction
            .addToBackStack(fragment.fragmentTag)
            .commitAllowingStateLoss()
    }

    protected fun FragmentTransaction.applyDefaultNextCustomAnimations(): FragmentTransaction {
        return this.apply {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
        }
    }

    protected fun FragmentTransaction.applyDefaultBackCustomAnimations(): FragmentTransaction {
        return this.apply {
            setCustomAnimations(
                R.anim.slide_in_left,
                R.anim.slide_out_right,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        }
    }
}
