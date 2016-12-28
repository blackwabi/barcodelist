package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.fragments.ArticleListFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by martinbegleiter on 26/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ArticlePresenterTest {

    @Mock
    Navigator mNavigator;

    @Mock
    DataManager mDataManager;

    @Mock
    ArticleListFragment mFragment;

    ArticlePresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mPresenter = new ArticlePresenter(mNavigator, mDataManager);
    }

    @Test
    public void onAddClicked() {
        mPresenter.onAddClicked();
        verify(mNavigator, times(1)).goToNewArticle();
    }

    @Test
    public void setFragment() {
        List<Article> articles = new ArrayList<>();
        when(mDataManager.getArticles()).thenReturn(articles);
        mPresenter.setFragment(mFragment);
        verify(mDataManager, times(1)).getArticles();
        verify(mFragment, times(1)).setList(articles);
    }
}