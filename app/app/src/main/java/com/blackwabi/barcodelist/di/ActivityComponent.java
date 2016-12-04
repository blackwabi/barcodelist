package com.blackwabi.barcodelist.di;

import com.blackwabi.barcodelist.Navigator;

import dagger.Subcomponent;

/**
 * Created by martinbegleiter on 04/12/16.
 */
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {
    FragmentComponent fragmentComponent();

    Navigator navigator();
}
