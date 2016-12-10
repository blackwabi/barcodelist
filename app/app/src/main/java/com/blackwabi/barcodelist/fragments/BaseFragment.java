package com.blackwabi.barcodelist.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.blackwabi.barcodelist.di.ActivityComponentContainer;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.BasePresenter;

import java.sql.Connection;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment{

    @Inject
    protected P mPresenter;

    protected Context mContext;
    private FragmentComponent mFragmentComponent;

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mContext = context;
            mFragmentComponent = ((ActivityComponentContainer) context).getActivityComponent()
                    .fragmentComponent();
            injectIntoComponentAndPresenter(mFragmentComponent);
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString()
                    + " must implement ActivityComponentContainer");
        }
    }

    @Override
    public void onDetach() {
        mFragmentComponent = null;
        super.onDetach();
    }

    protected abstract void injectIntoComponentAndPresenter(FragmentComponent component);
}
