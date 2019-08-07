package com.bohdan.common_kotlin_mvvm.ui.fragment;

public interface BaseFragmentCommander {

    default void showProgressDialog() { }

    default void hideProgressDialog() { }
}
