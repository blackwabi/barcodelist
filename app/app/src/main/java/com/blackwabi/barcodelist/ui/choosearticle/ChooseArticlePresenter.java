package com.blackwabi.barcodelist.ui.choosearticle;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.mvp.presenter.NamedListPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class ChooseArticlePresenter extends NamedListPresenter<Article, ChooseArticleFragment> {
    private final Navigator mNavigator;
    private final DataManager mDataManager;

    @Inject
    public ChooseArticlePresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    @Override
    protected boolean shouldShowFabs() {
        return false;
    }

    @Override
    public void removeItems(List<Article> articles) {
        // Not needed
    }

    @Override
    public void onAddClicked() {
        // Not needed
    }

    @Override
    public List<Article> getItems() {
        return mDataManager.getArticles();
    }

    public void onItemClicked(int position, Article article) {
        mDataManager.addExistingArticleToExistingList(mListName, article);
        mNavigator.goBack();
    }
}
