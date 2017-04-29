package com.blackwabi.barcodelist.di;

import android.support.v7.app.AppCompatActivity;

import com.blackwabi.barcodelist.BarcodeActivity;
import com.blackwabi.barcodelist.Navigator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by martinbegleiter on 04/12/16.
 */
@Module
public class ActivityModule {
    private final BarcodeActivity mActivity;

    public ActivityModule(BarcodeActivity activity) {
        mActivity = activity;
    }

    @Provides
    Navigator provideNavigator() {
        return new Navigator(mActivity);
    }

    @Provides
    BarcodeActivity provideActivity() {
        return mActivity;
    }
}
