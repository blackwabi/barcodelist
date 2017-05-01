package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.ui.choosearticle.ChooseArticleFragment;
import com.blackwabi.barcodelist.ui.choosearticle.ChooseArticlePresenter;

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
public class ChooseArticlePresenterTest {

    private static final String LIST_NAME = "list_name";
    @Mock
    Navigator mNavigator;

    @Mock
    DataManager mDataManager;

    @Mock
    ChooseArticleFragment mFragment;

    ChooseArticlePresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mPresenter = new ChooseArticlePresenter(mNavigator, mDataManager);
        mPresenter.setListName(LIST_NAME);
    }

    @Test
    public void onItemClicked() {
        Article article = new Article();
        mPresenter.onItemClicked(0, article);
        verify(mDataManager, times(1)).addExistingArticleToExistingList(LIST_NAME, article);
        verify(mNavigator, times(1)).goBack();
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