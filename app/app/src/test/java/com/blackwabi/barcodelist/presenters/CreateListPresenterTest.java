package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.ui.createlist.CreateListFragment;
import com.blackwabi.barcodelist.ui.createlist.CreateListPresenter;

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
public class CreateListPresenterTest {

    private static final String LIST_NAME = "LIST_NAME";

    @Mock
    Navigator mNavigator;

    @Mock
    DataManager mDataManager;

    @Mock
    CreateListFragment mFragment;

    CreateListPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        mPresenter = new CreateListPresenter(mNavigator, mDataManager);
        mPresenter.setFragment(mFragment);
    }

    @Test
    public void onSaveListNameClick() throws Exception {
        mPresenter.onSaveListNameClick(LIST_NAME);
        verify(mDataManager, times(1)).addArticleList(LIST_NAME);
        verify(mNavigator, times(1)).goToList(LIST_NAME);
    }

    @Test
    public void onCancelClick() throws Exception {
        mPresenter.onCancelClick();
        verify(mNavigator, times(1)).goToLists();
    }
}