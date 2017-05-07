package com.blackwabi.barcodelist.ui.showarticlelists;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.ArticleList;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.mvp.fragment.RemovalListFragment;

/**
 * Created by martinbegleiter on 23/11/16.
 */
public class ShowArticleListsFragment extends RemovalListFragment<ArticleList, ArticleListAdapter, ShowArticleListsPresenter> {



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
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setOnItemClickListener(((position, articleList) -> mPresenter.onItemClicked(position, articleList)));
        setOnItemLongClickListener(((position, articleList) -> mPresenter.onItemLongClicked(position, articleList)));
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        mPresenter.setFragment(this);
        setTitle(R.string.article_lists);
    }
}
