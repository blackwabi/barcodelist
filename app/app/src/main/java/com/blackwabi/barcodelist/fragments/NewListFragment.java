package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.NewListPresenter;

/**
 * Created by martinbegleiter on 29/12/16.
 */

// TODO: If we want to have a different layout of article items than in the article list,
// then we need to create a specific adapter. Using articleadapter for now
public class NewListFragment extends ListFragment<Article, ArticleAdapter, NewListPresenter> {

    private static final String ARGS_LIST_NAME = "list_name";

    @Override
    protected ArticleAdapter createListAdapter() {
        return new ArticleAdapter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_new_list;
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
        mPresenter.setListName(getArguments().getString(ARGS_LIST_NAME));
    }

    public static NewListFragment newInstance(String listName) {
        NewListFragment newListFragment = new NewListFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_LIST_NAME, listName);
        newListFragment.setArguments(args);
        return newListFragment;
    }
}
