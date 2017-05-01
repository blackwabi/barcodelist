package com.blackwabi.barcodelist.ui.showarticles;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.mvp.presenter.RemovalListPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class ShowArticlesPresenter extends RemovalListPresenter<Article, ShowArticlesFragment> {
    private final Navigator mNavigator;
    private final DataManager mDataManager;

    public void onAddClicked() {
        mNavigator.goToCreateArticle();
    }

    @Override
    public List<Article> getItems() {
        return mDataManager.getArticles();
    }

    @Inject
    public ShowArticlesPresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
        //createArticles();
    }

    private void createArticles() {
        mDataManager.addArticle("Heinz Ketchup", "111");
        mDataManager.addArticle("Korv", "222");
        mDataManager.addArticle("Bröd", "333");
        mDataManager.addArticle("Senap", "444");
        mDataManager.addArticle("Choklad", "555");
        mDataManager.addArticle("Mjölk", "555");
    }

    @Override
    protected boolean shouldShowFabs() {
        return true;
    }

    @Override
    public void removeItems(List<Article> articles) {
        mDataManager.removeArticles(articles);
    }
}
