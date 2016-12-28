package com.blackwabi.barcodelist.fragments;

import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.ArticlePresenter;

/**
 * Created by martinbegleiter on 23/11/16.
 */
public class ArticleListFragment extends ListFragment<Article, ArticleAdapter, ArticlePresenter> {

    @Override
    protected ArticleAdapter createListAdapter() {
        return new ArticleAdapter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_articlelist;
    }

    @Override
    public void initCreatedView(View view) {
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(fabView -> getPresenter().onAddClicked());
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        getPresenter().setFragment(this);
    }
}
