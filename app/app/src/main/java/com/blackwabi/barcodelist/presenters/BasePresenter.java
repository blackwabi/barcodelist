package com.blackwabi.barcodelist.presenters;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class BasePresenter<FRAGMENT> {
    protected FRAGMENT mFragment;

    public void setFragment(FRAGMENT fragment) {
        mFragment = fragment;
        fragmentInit();
    }

    protected void fragmentInit() {
        // Not implemented, override if needed
    }
}
