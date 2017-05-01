package com.blackwabi.barcodelist.mvp.presenter;

import com.blackwabi.barcodelist.mvp.fragment.RemovalListFragment;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class NamedListPresenter<ITEM, FRAGMENT extends RemovalListFragment<ITEM,?,?>> extends RemovalListPresenter<ITEM, FRAGMENT> {
    protected String mListName;

    public void setListName(String name) {
        mListName = name;
    }
}
