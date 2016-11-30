package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.di.BarcodeComponent;
import com.blackwabi.barcodelist.presenters.ArticlePresenter;

/**
 * Created by martinbegleiter on 23/11/16.
 */
public class ArticleListFragment extends BaseFragment<ArticlePresenter> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articlelist, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.article_list);
        recyclerView.setAdapter(new ArticleAdapter());

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(fabView -> getPresenter().onAddClicked());

        return view;
    }

    @Override
    protected void injectIntoComponentAndPresenter(BarcodeComponent component) {
        component.inject(this);
        getPresenter().setFragment(this);
    }
}
