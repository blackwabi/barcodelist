package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.fragments.ArticleListFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class ArticlePresenter extends BasePresenter<ArticleListFragment> {
    private final Navigator mNavigator;

    public void onAddClicked() {
        mNavigator.goToNewArticle();
    }

    @Inject
    public ArticlePresenter(Navigator navigator) {
        mNavigator = navigator;
    }
}
