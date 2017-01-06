package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.ChooseArticlePresenter;

/**
 * Created by martinbegleiter on 23/11/16.
 */
public class ChooseArticleFragment extends ListFragment<Article, ArticleAdapter, ChooseArticlePresenter> {

    private static final String ARGS_LIST_NAME = "list_name";

    @Override
    protected ArticleAdapter createListAdapter() {
        return new ArticleAdapter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_choose_article;
    }

    @Override
    public void initCreatedView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setOnItemClickListener(((position, article) -> mPresenter.onItemClicked(position, article)));
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        mPresenter.setFragment(this);
        final String listName = getArguments().getString(ARGS_LIST_NAME);
        mPresenter.setListName(listName);
        final String title = getResources().getString(R.string.choose_article_for_list, listName);
        setTitle(title);
    }

    public static ChooseArticleFragment newInstance(String listName) {
        ChooseArticleFragment chooseArticleFragment = new ChooseArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_LIST_NAME, listName);
        chooseArticleFragment.setArguments(args);
        return chooseArticleFragment;
    }
}