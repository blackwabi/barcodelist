package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.fragments.NewListNameFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public class NewListNamePresenter extends BasePresenter<NewListNameFragment> {

    private final Navigator mNavigator;

    @Inject
    public NewListNamePresenter(Navigator navigator) {
        mNavigator = navigator;
    }

    public void onSaveListNameClick(String listName) {
        mNavigator.goToNewList(listName);
    }

    public void onCancelClick() {
        mFragment.dismiss();
        mNavigator.goToLists();
    }
}
