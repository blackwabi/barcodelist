package com.blackwabi.barcodelist.presenters;

import android.support.v4.app.Fragment;

import com.blackwabi.barcodelist.mvp.presenter.BasePresenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by martinbegleiter on 26/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class BasePresenterTest {

    @Mock
    Fragment mFragment;

    @Spy
    BasePresenter mPresenter;

    @Test
    public void setFragment() throws Exception {
        mPresenter.setFragment(mFragment);
        verify(mPresenter,times(1)).fragmentInit();
    }
}