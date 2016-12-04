package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.fragments.ArticleListListFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class ArticleListPresenter extends BasePresenter<ArticleListListFragment> {
    private final Navigator mNavigator;

    public void onAddClicked() {
        //TODO: Implement this
    }

    @Inject
    public ArticleListPresenter(Navigator navigator) {
        mNavigator = navigator;
    }
}
