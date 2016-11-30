package com.blackwabi.barcodelist.presenters;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class BasePresenter<F> {
    protected F mFragment;

    protected F getFragment() {
        return mFragment;
    }

    public void setFragment(F fragment) {
        mFragment = fragment;
    }
}
