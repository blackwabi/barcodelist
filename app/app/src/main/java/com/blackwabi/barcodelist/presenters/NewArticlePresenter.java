package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.fragments.NewArticleFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 04/12/16.
 */
public class NewArticlePresenter extends BasePresenter<NewArticleFragment>{

    private final Navigator mNavigator;

    @Inject
    public NewArticlePresenter(Navigator navigator) {
        mNavigator = navigator;
    }

    public void onSaveClicked(String articleName, String articleCode) {
        //TODO: Implement
    }
}
