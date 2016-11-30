package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.blackwabi.barcodelist.BarcodeApp;
import com.blackwabi.barcodelist.di.BarcodeComponent;
import com.blackwabi.barcodelist.presenters.BasePresenter;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment{

    @Inject
    protected T mPresenter;

    protected T getPresenter() {
        return mPresenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarcodeComponent component = BarcodeApp.getComponent();
        injectIntoComponentAndPresenter(component);
    }

    protected abstract void injectIntoComponentAndPresenter(BarcodeComponent component);
}
