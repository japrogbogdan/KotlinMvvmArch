package com.bohdan.common_kotlin_mvvm.ui.fragment

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

open class MvvmFragment : Fragment() {

    lateinit var baseFragmentCommander: BaseFragmentCommander

    @CallSuper
    override fun onAttach(context: Context?) {
        setupCommander(context)
        super.onAttach(context)
    }

    @CallSuper
    protected open fun setupCommander(context: Context?) {
        if (context is BaseFragmentCommander) {
            baseFragmentCommander = context
        }
    }

    protected fun hideKeyboard() {
        if (activity == null || !isAdded || activity !is Activity) return

        val activity = activity as Activity
        val view = activity.currentFocus ?: return
        val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    protected fun showKeyboard(editText: EditText?) {
        editText?.let {
            editText.requestFocus()
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    inline fun <reified Commander : BaseFragmentCommander> commander(function: Commander.() -> Unit) {
        context?.let {
            if (it is Commander) function(it)
        }
    }

    interface BaseFragmentCommander {
        fun showProgressDialog()
        fun hideProgressDialog()
    }
}