package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.NewArticleFragment;

import javax.inject.Inject;

/**
 * Created by martinbegleiter on 04/12/16.
 */
public class NewArticlePresenter extends BasePresenter<NewArticleFragment>{

    private final Navigator mNavigator;
    private final DataManager mDataManager;

    @Inject
    public NewArticlePresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    public void onSaveClicked(String articleName, String articleCode) {
        mDataManager.addArticle(articleName, articleCode);
        mNavigator.goToArticles();
    }
}
