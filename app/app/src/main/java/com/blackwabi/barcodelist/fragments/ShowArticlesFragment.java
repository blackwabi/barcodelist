package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.ShowArticlesPresenter;

/**
 * Created by martinbegleiter on 23/11/16.
 */
public class ShowArticlesFragment extends RemovalListFragment<Article, ArticleCardAdapter, ShowArticlesPresenter> {

    @Override
    protected ArticleCardAdapter createListAdapter() {
        return new ArticleCardAdapter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_articlelist;
    }

    @Override
    public void initCreatedView(View view, Bundle savedInstanceState) {
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.add_fab);
        fab.setOnClickListener(fabView -> mPresenter.onAddClicked());
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        mPresenter.setFragment(this);
        setTitle(R.string.articles);
    }
}
