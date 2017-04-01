package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.fragments.UseArticleListFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class UseArticleListPresenter extends NamedListPresenter<Article, UseArticleListFragment> {

    private final Navigator mNavigator;
    private final DataManager mDataManager;

    @Inject
    public UseArticleListPresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    public void onAddClicked() {
        mNavigator.goToChooseArticle(mListName);
    }

    @Override
    public List<Article> getItems() {
        return mDataManager.getArticlesInList(mListName);
    }

    @Override
    protected boolean shouldShowFabs() {
        return true;
    }

    @Override
    public void removeItems(List<Article> articles) {
        mDataManager.removeArticlesFromSpecificList(mListName, articles);
    }
}
