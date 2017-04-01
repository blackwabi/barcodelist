package com.blackwabi.barcodelist.presenters;

/**
 * Created by martinbegleiter on 01/04/17.
 */

public class CheckedListItem<ITEM> {
    private ITEM mItem;
    private boolean mChecked;

    public CheckedListItem(ITEM item) {
        mItem = item;
        mChecked = false;
    }

    public ITEM getItem() {
        return mItem;
    }

    public boolean isChecked() {
        return mChecked;
    }

    public void setChecked(boolean checked) {
        mChecked = checked;
    }
}
