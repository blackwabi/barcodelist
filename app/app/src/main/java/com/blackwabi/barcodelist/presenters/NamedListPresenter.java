package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.fragments.RemovalListFragment;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class NamedListPresenter<ITEM, FRAGMENT extends RemovalListFragment<ITEM,?,?>> extends RemovalListPresenter<ITEM, FRAGMENT> {
    protected String mListName;

    public void setListName(String name) {
        mListName = name;
    }
}
