package com.blackwabi.barcodelist.di;

import com.blackwabi.barcodelist.BarcodeApp;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.fragments.ArticleListFragment;
import com.blackwabi.barcodelist.fragments.ArticleListListFragment;
import com.blackwabi.barcodelist.fragments.BaseFragment;

import dagger.Component;

/**
 * Created by martinbegleiter on 27/11/16.
 */

@Component(modules = { PresenterModule.class})
public interface BarcodeComponent {
    DataManager dataManager();

    void inject(ArticleListListFragment articleListListFragment);

    void inject(ArticleListFragment articleListFragment);

    final class Initializer {
        /** Hide constructor * */
        private Initializer() {
        }

        public static BarcodeComponent init(BarcodeApp app) {
            BarcodeComponent barcodeComponent = DaggerBarcodeComponent.builder()
                    .presenterModule(new PresenterModule(app))
                    .build();

            return barcodeComponent;
        }
    }
}
