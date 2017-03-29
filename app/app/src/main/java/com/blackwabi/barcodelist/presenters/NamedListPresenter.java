package com.blackwabi.barcodelist.presenters;

import com.blackwabi.barcodelist.fragments.ListFragment;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class NamedListPresenter<F extends ListFragment> extends BasePresenter<F> {
    protected String mListName;

    public void setListName(String name) {
        mListName = name;
    }
}
