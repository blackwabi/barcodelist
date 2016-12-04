package com.blackwabi.barcodelist.di;

import com.blackwabi.barcodelist.BarcodeApp;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.ArticleListFragment;
import com.blackwabi.barcodelist.fragments.ArticleListListFragment;

import dagger.Component;

/**
 * Created by martinbegleiter on 27/11/16.
 */

@Component(modules = { EnvironmentModule.class})
public interface BarcodeComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    DataManager dataManager();

    final class Initializer {
        /** Hide constructor * */
        private Initializer() {
        }

        public static BarcodeComponent init(BarcodeApp app) {
            BarcodeComponent barcodeComponent = DaggerBarcodeComponent.builder()
                    .environmentModule(new EnvironmentModule(app))
                    .build();

            return barcodeComponent;
        }
    }
}
