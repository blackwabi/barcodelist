package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.UseArticleListFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class UseArticleListPresenter extends NamedListPresenter<UseArticleListFragment> {

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
    protected void fragmentInit() {
        mFragment.setList(mDataManager.getArticlesInList(mListName));
    }
}
