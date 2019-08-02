package com.ja_company.common_kotlin_mvvm.library.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.ja_company.common_kotlin_mvvm.library.navigation.MvvmActivitiesNavigator
import com.ja_company.common_kotlin_mvvm.library.navigation.MvvmFragmentNavigator
import org.koin.android.ext.android.getKoin
import org.koin.core.parameter.parametersOf
import kotlin.reflect.KClass

abstract class MvvmActivity<FN : MvvmFragmentNavigator, N: MvvmActivitiesNavigator>(val fnClazz: KClass<FN>, val nClazz: KClass<N>) : AppCompatActivity() {

    lateinit var fragmentNavigator: FN

    lateinit var navigator: N

    @get:IdRes
    abstract val containerResId: Int

    @get:LayoutRes
    protected abstract val layoutResId: Int

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutResId)

        fragmentNavigator = getKoin().get(fnClazz, null) { parametersOf(this@MvvmActivity) }

        navigator = getKoin().get(nClazz, null) { parametersOf(this@MvvmActivity) }
    }

    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        supportFragmentManager.fragments.map {
            it.onActivityResult(requestCode, resultCode, data)
        }
    }
}