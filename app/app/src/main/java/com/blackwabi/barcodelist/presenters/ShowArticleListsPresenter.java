package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.ArticleList;
import com.blackwabi.barcodelist.fragments.ShowArticleListsFragment;

import java.util.Collections;
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
        mNavigator.goToList(articleList.listName);
    }
}
