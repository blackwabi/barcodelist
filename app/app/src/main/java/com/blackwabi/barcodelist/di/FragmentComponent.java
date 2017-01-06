package com.blackwabi.barcodelist.di;

import com.blackwabi.barcodelist.fragments.ChooseArticleFragment;
import com.blackwabi.barcodelist.fragments.CreateListFragment;
import com.blackwabi.barcodelist.fragments.ShowArticlesFragment;
import com.blackwabi.barcodelist.fragments.ShowArticleListsFragment;
import com.blackwabi.barcodelist.fragments.CreateArticleFragment;
import com.blackwabi.barcodelist.fragments.UseArticleListFragment;

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
