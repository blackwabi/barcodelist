package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.CreateListFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class CreateListPresenter extends BasePresenter<CreateListFragment> {

    private final Navigator mNavigator;
    private final DataManager mDataManager;

    @Inject
    public CreateListPresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    public void onSaveListNameClick(String listName) {
        mDataManager.addArticleList(listName);
        mNavigator.goToList(listName);
    }

    public void onCancelClick() {
        mNavigator.goToLists();
    }
}
