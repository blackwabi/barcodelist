package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.NewArticlePresenter;


/**
 * Created by martinbegleiter on 04/12/16.
 */

public class NewArticleFragment extends BaseFragment<NewArticlePresenter>{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_article, container, false);
        return view;
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        getPresenter().setFragment(this);
    }
}
