package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.data.model.ArticleList;
import com.blackwabi.barcodelist.fragments.ArticleListListFragment;

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
public class ArticleListPresenterTest {

    @Mock
    Navigator mNavigator;

    @Mock
    DataManager mDataManager;

    @Mock
    ArticleListListFragment mFragment;

    ArticleListPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mPresenter = new ArticleListPresenter(mNavigator, mDataManager);
    }

    @Test
    public void onAddClicked() {
        mPresenter.onAddClicked();
        verify(mNavigator, times(1)).goToNewArticleListName();
    }

    @Test
    public void setFragment() {
        List<ArticleList> articleLists = new ArrayList<>();
        when(mDataManager.getArticleLists()).thenReturn(articleLists);
        mPresenter.setFragment(mFragment);
        verify(mDataManager, times(1)).getArticleLists();
        verify(mFragment, times(1)).setList(articleLists);
    }
}