package com.blackwabi.barcodelist;

import android.app.Application;

import com.blackwabi.barcodelist.di.BarcodeComponent;

import io.realm.Realm;

/**
 * Created by martinbegleiter on 27/11/16.
 */

public class BarcodeApp extends Application {
    private static BarcodeComponent sComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        sComponent = BarcodeComponent.Initializer.init(this);
    }

    public static BarcodeComponent getComponent() {
        return  sComponent;
    }
}
