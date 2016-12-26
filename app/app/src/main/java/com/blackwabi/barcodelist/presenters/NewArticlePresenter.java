package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.NewArticleFragment;
import com.google.zxing.Result;

import javax.inject.Inject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by martinbegleiter on 04/12/16.
 */
public class NewArticlePresenter extends BasePresenter<NewArticleFragment> implements
        ZXingScannerView.ResultHandler {

    private final Navigator mNavigator;
    private final DataManager mDataManager;
    private String mScannedCode;

    @Inject
    public NewArticlePresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    public void onSaveClicked(String articleName) {
        mDataManager.addArticle(articleName, mScannedCode);
        mNavigator.goToArticles();
    }

    public void onScannerClicked() {
        mFragment.showScanner(true);
    }

    @Override
    public void handleResult(Result result) {
        mScannedCode = result.getText();
        mFragment.setScannedCode(mScannedCode);
        mFragment.showScanner(false);
    }
}
