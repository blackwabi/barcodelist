package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.fragments.ChooseArticleFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class ChooseArticlePresenter extends NamedListPresenter<ChooseArticleFragment> {
    private final Navigator mNavigator;
    private final DataManager mDataManager;

    @Inject
    public ChooseArticlePresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    @Override
    protected void fragmentInit() {
        mFragment.setList(mDataManager.getArticles());
    }

    public void onItemClicked(int position, Article article) {
        mDataManager.addExistingArticleToExistingList(mListName, article);
        mNavigator.goBack();
    }
}
