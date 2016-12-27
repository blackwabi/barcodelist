package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.NewArticleFragment;
import com.google.zxing.Result;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by martinbegleiter on 26/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class NewArticlePresenterTest {

    private static final String ARTICLE_NAME = "TEST";
    private static final java.lang.String ARTICLE_CODE = "123456";

    @Mock
    Navigator mNavigator;

    @Mock
    DataManager mDataManager;

    @Mock
    NewArticleFragment mFragment;

    NewArticlePresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mPresenter = new NewArticlePresenter(mNavigator, mDataManager);
        mPresenter.setFragment(mFragment);
    }

    @Test
    public void onSaveClicked() throws Exception {
        mPresenter.onSaveClicked(ARTICLE_NAME);
        verify(mDataManager,times(1)).addArticle(ARTICLE_NAME, null);
        verify(mNavigator, times(1)).goToArticles();
    }

    @Test
    public void onScannerClicked() throws Exception {
        mPresenter.onScannerClicked();
        verify(mFragment, times(1)).showScanner(true);
    }

    @Test
    public void handleResult() {
        Result result = new Result(ARTICLE_CODE, null, null, null);
        mPresenter.handleResult(result);
        verify(mFragment, times(1)).setScannedCode(ARTICLE_CODE);
        verify(mFragment, times(1)).showScanner(false);
    }
}