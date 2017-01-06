package com.blackwabi.barcodelist.fragments;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.blackwabi.barcodelist.di.ActivityComponentContainer;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.BasePresenter;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment{

    private String mTitleString;
    private int mTitleId;

    private enum TitleType {
        RESOURCE,
        STRING,
        NONE
    }

    @Inject
    protected P mPresenter;

    protected AppCompatActivity mActivity;
    private FragmentComponent mFragmentComponent;

    private TitleType mTitleType = TitleType.NONE;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mActivity = (AppCompatActivity) context;
            mFragmentComponent = ((ActivityComponentContainer) context).getActivityComponent()
                    .fragmentComponent();
            injectIntoComponentAndPresenter(mFragmentComponent);
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString()
                    + " must implement ActivityComponentContainer and must be an AppCompatActivity");
        }
    }

    @Override
    public void onDetach() {
        mFragmentComponent = null;
        super.onDetach();
    }

    protected abstract void injectIntoComponentAndPresenter(FragmentComponent component);

    protected void setTitle(String title) {
        mTitleString = title;
        mTitleType = TitleType.STRING;
    }

    protected void setTitle(@StringRes int title) {
        mTitleId = title;
        mTitleType = TitleType.RESOURCE;
    }

    @Override
    public void onResume() {
        super.onResume();
        switch(mTitleType) {
            case RESOURCE:
                mActivity.setTitle(mTitleId);
                break;

            case STRING:
                mActivity.setTitle(mTitleString);
                break;

            case NONE:
            default:
                    // Do nothing
        }
    }
}
