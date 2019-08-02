package com.ja_company.common_kotlin_mvvm.sample.ui.twoFragment

import android.os.Bundle
import com.ja_company.common_kotlin_mvvm.R
import com.ja_company.common_kotlin_mvvm.library.toolbar.MainToolbarWrapper
import com.ja_company.common_kotlin_mvvm.library.ui.fragment.MvvmToolbarViewModelFragment
import com.ja_company.common_kotlin_mvvm.library.ui.fragment.MvvmViewModelFragment
import kotlinx.android.synthetic.main.one_fragment_layout.*

class TwoFragment : MvvmToolbarViewModelFragment<MainToolbarWrapper.MainToolbarCommander,TwoFragmentViewModel>(
    TwoFragmentViewModel::class) {

    override val fragmentTag: String get() = "TwoFragment"

    override val layoutId: Int get() = R.layout.two_fragment_layout

    companion object {
        fun newInstance() = TwoFragment().apply { arguments = Bundle().apply { } }
    }

    override fun setupToolbar() {
        toolbarCommander.setToolbarTitle("Hello two fragment")
    }

    override fun onViewReady() {
        super.onViewReady()
        btn_view.setOnClickListener { commander<TwoFragmentCommander> { openOneFragment() } }
    }

    interface TwoFragmentCommander : BaseFragmentCommander {
        fun openOneFragment()
    }
}