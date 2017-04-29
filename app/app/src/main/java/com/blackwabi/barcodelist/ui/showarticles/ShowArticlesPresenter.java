package com.blackwabi.barcodelist.ui.showarticles;

import android.net.Uri;

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
        String bunnyUri = Uri.parse("android.resource://com.blackwabi.barcodelist/drawable/babybunny")
                .toString();
        mDataManager.addArticle("Heinz Ketchup", "111", bunnyUri);
        mDataManager.addArticle("Korv", "222", bunnyUri);
        mDataManager.addArticle("Bröd", "333", bunnyUri);
        mDataManager.addArticle("Senap", "444", bunnyUri);
        mDataManager.addArticle("Choklad", "555", bunnyUri);
        mDataManager.addArticle("Mjölk", "555", bunnyUri);
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
