package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.ShowArticlesFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class ShowArticlesPresenter extends BasePresenter<ShowArticlesFragment> {
    private final Navigator mNavigator;
    private final DataManager mDataManager;

    public void onAddClicked() {
        mNavigator.goToCreateArticle();
    }

    @Inject
    public ShowArticlesPresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    @Override
    protected void fragmentInit() {
        mFragment.setList(mDataManager.getArticles());
    }
}
