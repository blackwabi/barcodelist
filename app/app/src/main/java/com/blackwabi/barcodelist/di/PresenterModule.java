package com.blackwabi.barcodelist.di;

import android.content.Context;

import com.blackwabi.barcodelist.BarcodeApp;
import com.blackwabi.barcodelist.presenters.ArticleListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by martinbegleiter on 27/11/16.
 */

@Module
public class PresenterModule {
    private final BarcodeApp mApp;

    public PresenterModule(BarcodeApp app) {
        mApp = app;
    }

    @Provides
    public Context provideContext() {
       return mApp;
    }
}
