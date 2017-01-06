package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.UseArticleListFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class UseArticleListPresenter extends BasePresenter<UseArticleListFragment> {

    private final Navigator mNavigator;
    private final DataManager mDataManager;
    private String mListName;

    @Inject
    public UseArticleListPresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    public void onAddClicked() {
        // TODO: Implement
    }

    @Override
    protected void fragmentInit() {
        mFragment.setList(mDataManager.getArticlesInList(mListName));
    }

    public void setListName(String name) {
        mListName = name;
    }
}
