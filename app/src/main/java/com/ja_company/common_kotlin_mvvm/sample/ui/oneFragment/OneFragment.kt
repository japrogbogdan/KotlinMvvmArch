package com.ja_company.common_kotlin_mvvm.sample.ui.oneFragment

import android.os.Bundle
import com.bohdan.common_kotlin_mvvm.ui.fragment.MvvmToolbarViewModelFragment
import com.ja_company.common_kotlin_mvvm.R
import com.ja_company.common_kotlin_mvvm.sample.ui.MainToolbarWrapper
import kotlinx.android.synthetic.main.one_fragment_layout.*

class OneFragment : MvvmToolbarViewModelFragment<MainToolbarWrapper.MainToolbarCommander, OneFragmentViewModel>(
    OneFragmentViewModel::class) {

    override val fragmentTag: String get() = "OneFragment"

    override val layoutId: Int get() = R.layout.one_fragment_layout

    companion object {
        fun newInstance() = OneFragment().apply { arguments = Bundle().apply { } }
    }

    override fun setupToolbar() {
        toolbarCommander.setToolbarTitle("Hello one fragment")
    }

    override fun onViewReady() {
        super.onViewReady()
        btn_view.setOnClickListener { commander<OneFragmentCommander> { openTwoFragment() } }
    }

    interface OneFragmentCommander: BaseFragmentCommander {
        fun openTwoFragment()
    }
}