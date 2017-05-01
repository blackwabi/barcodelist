package com.blackwabi.barcodelist.mvp.fragment;

import android.content.Context;
import android.support.v4.app.DialogFragment;

import com.blackwabi.barcodelist.di.ActivityComponentContainer;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.mvp.presenter.BasePresenter;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class BaseDialogFragment<P extends BasePresenter> extends DialogFragment {

    @Inject
    protected P mPresenter;

    protected Context mContext;
    private FragmentComponent mFragmentComponent;

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
