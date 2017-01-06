package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.ArticleList;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.ShowArticleListsPresenter;

/**
 * Created by martinbegleiter on 23/11/16.
 */
public class ShowArticleListsFragment extends ListFragment<ArticleList, ArticleListAdapter, ShowArticleListsPresenter> {

    @Override
    protected ArticleListAdapter createListAdapter() {
        return new ArticleListAdapter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_articlelistlist;
    }

    @Override
    protected void initCreatedView(View view, Bundle savedInstanceState) {
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(fabView -> mPresenter.onAddClicked());
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        mPresenter.setFragment(this);
    }
}
