package com.blackwabi.barcodelist.ui.showarticlelists;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.ArticleList;
import com.blackwabi.barcodelist.mvp.presenter.RemovalListPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class ShowArticleListsPresenter extends RemovalListPresenter<ArticleList, ShowArticleListsFragment> {
    private final Navigator mNavigator;
    private final DataManager mDataManager;

    @Inject
    public ShowArticleListsPresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    @Override
    protected boolean shouldShowFabs() {
        return true;
    }

    @Override
    public void removeItems(List<ArticleList> articleLists) {
        mDataManager.removeArticleLists(articleLists);
    }

    @Override
    public void onAddClicked() {
        mNavigator.goToCreateList();
    }

    @Override
    public List<ArticleList> getItems() {
        return mDataManager.getArticleLists();
    }

    public void onItemClicked(int position, ArticleList articleList) {
        mNavigator.runList(articleList.listName);
    }

    public boolean onItemLongClicked(int position, ArticleList articleList) {
        mNavigator.goToList(articleList.listName);
        return true;
    }
}
