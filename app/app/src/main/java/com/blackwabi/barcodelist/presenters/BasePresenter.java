package com.blackwabi.barcodelist.presenters;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class BasePresenter<F> {
    protected F mFragment;

    public void setFragment(F fragment) {
        mFragment = fragment;
        fragmentInit();
    }

    protected void fragmentInit() {
        // Not implemented, override if needed
    }
}
