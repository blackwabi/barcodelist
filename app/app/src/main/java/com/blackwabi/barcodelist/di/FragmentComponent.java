package com.blackwabi.barcodelist.di;

import com.blackwabi.barcodelist.fragments.ArticleListFragment;
import com.blackwabi.barcodelist.fragments.ArticleListListFragment;

import dagger.Subcomponent;

/**
 * Created by martinbegleiter on 04/12/16.
 */
@Subcomponent
public interface FragmentComponent {
    void inject(ArticleListFragment articleListFragment);

    void inject(ArticleListListFragment articleListListFragment);
}
