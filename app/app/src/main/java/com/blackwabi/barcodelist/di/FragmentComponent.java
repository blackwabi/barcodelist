package com.blackwabi.barcodelist.di;

import com.blackwabi.barcodelist.ui.choosearticle.ChooseArticleFragment;
import com.blackwabi.barcodelist.ui.createlist.CreateListFragment;
import com.blackwabi.barcodelist.ui.showarticles.ShowArticlesFragment;
import com.blackwabi.barcodelist.ui.showarticlelists.ShowArticleListsFragment;
import com.blackwabi.barcodelist.ui.createarticle.CreateArticleFragment;
import com.blackwabi.barcodelist.ui.usearticlelist.UseArticleListFragment;

import dagger.Subcomponent;

/**
 * Created by martinbegleiter on 04/12/16.
 */
@Subcomponent
public interface FragmentComponent {
    void inject(ShowArticlesFragment showArticlesFragment);

    void inject(ShowArticleListsFragment showArticleListsFragment);

    void inject(CreateArticleFragment createArticleFragment);

    void inject(CreateListFragment createListFragment);

    void inject(UseArticleListFragment useArticleListFragment);

    void inject(ChooseArticleFragment chooseArticleFragment);
}
