package com.blackwabi.barcodelist.fragments;

import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.ArticleList;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.ArticleListPresenter;

/**
 * Created by martinbegleiter on 23/11/16.
 */
public class ArticleListListFragment extends ListFragment<ArticleList, ArticleListAdapter, ArticleListPresenter> {

    @Override
    protected ArticleListAdapter createListAdapter() {
        return new ArticleListAdapter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_articlelistlist;
    }

    @Override
    protected void initCreatedView(View view) {
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(fabView -> getPresenter().onAddClicked());
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        getPresenter().setFragment(this);
    }
}
