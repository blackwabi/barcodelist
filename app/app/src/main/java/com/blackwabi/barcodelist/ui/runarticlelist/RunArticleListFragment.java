package com.blackwabi.barcodelist.ui.runarticlelist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.mvp.fragment.RemovalListFragment;

/**
 * Created by martinbegleiter on 29/12/16.
 */

public class RunArticleListFragment extends RemovalListFragment<Article, RunArticleAdapter, RunArticleListPresenter> {

    private static final String ARGS_LIST_NAME = "list_name";

    @Override
    protected RunArticleAdapter createListAdapter() {
        return new RunArticleAdapter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_run_article_list;
    }

    @Override
    protected void initCreatedView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        final String listName = getArguments().getString(ARGS_LIST_NAME);
        mPresenter.setListName(listName);
        mPresenter.setFragment(this);
        setTitle(listName);
    }

    public static RunArticleListFragment newInstance(String listName) {
        RunArticleListFragment runArticleListFragment = new RunArticleListFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_LIST_NAME, listName);
        runArticleListFragment.setArguments(args);
        return runArticleListFragment;
    }
}
