package com.blackwabi.barcodelist.ui.runarticlelist;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.mvp.presenter.NamedListPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class RunArticleListPresenter extends NamedListPresenter<Article, RunArticleListFragment> {

    private final Navigator mNavigator;
    private final DataManager mDataManager;

    @Inject
    public RunArticleListPresenter(Navigator navigator, DataManager dataManager) {
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
        return false;
    }

    @Override
    public void removeItems(List<Article> articles) {
        mDataManager.removeArticlesFromSpecificList(mListName, articles);
    }
}
