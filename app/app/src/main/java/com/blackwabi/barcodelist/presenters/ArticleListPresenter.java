package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.ArticleListListFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class ArticleListPresenter extends BasePresenter<ArticleListListFragment> {
    private final Navigator mNavigator;
    private final DataManager mDataManager;

    public void onAddClicked() {
        mNavigator.goToNewArticleList();
    }

    @Inject
    public ArticleListPresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    @Override
    protected void fragmentInit() {
        mFragment.setList(mDataManager.getArticleLists());
    }
}
