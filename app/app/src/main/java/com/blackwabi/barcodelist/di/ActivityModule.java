package com.blackwabi.barcodelist.di;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.blackwabi.barcodelist.Navigator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by martinbegleiter on 04/12/16.
 */
@Module
public class ActivityModule {
    private final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    Navigator provideNavigator() {
        return new Navigator(mActivity);
    }
}
