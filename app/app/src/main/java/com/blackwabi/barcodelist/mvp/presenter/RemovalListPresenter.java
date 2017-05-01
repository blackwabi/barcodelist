package com.blackwabi.barcodelist.mvp.presenter;

import com.blackwabi.barcodelist.mvp.CheckedListItem;
import com.blackwabi.barcodelist.mvp.fragment.RemovalListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martinbegleiter on 29/11/16.
 */

public abstract class RemovalListPresenter<ITEM, FRAGMENT extends RemovalListFragment<ITEM, ?, ?>> extends BasePresenter<FRAGMENT> implements RemovalListFragment.ItemClickListener<CheckedListItem<ITEM>> {
    private FRAGMENT mFragment;
    private List<CheckedListItem<ITEM>> mItems = new ArrayList<>();

    public void setFragment(FRAGMENT fragment) {
        mFragment = fragment;
        mFragment.setOnItemRemoveClickListener(this);
        fragmentInit();
        mFragment.setShowFabs(shouldShowFabs());
    }

    protected void fragmentInit() {
        // Not implemented, override if needed
    }

    protected abstract boolean shouldShowFabs();

    public abstract void removeItems(List<ITEM> items);

    public abstract void onAddClicked();

    public abstract List<ITEM> getItems();

    public List<CheckedListItem<ITEM>> getCheckedItems() {
        mItems = createCheckedListFromList(getItems());
        return mItems;
    }

    public boolean onAddLongClicked() {
        mFragment.showRemoveState(true);
        return true;
    }

    public void onRemoveClicked() {
        List<ITEM> itemsToRemove = getItemsToRemove();
        if (itemsToRemove.size() > 0) {
            removeItems(itemsToRemove);
        }
        mFragment.update();
        mFragment.showRemoveState(false);
    }

    public void onCancelClicked() {
        clearCheckedItems();
        mFragment.update();
        mFragment.showRemoveState(false);
    }

    private List<ITEM> getItemsToRemove() {
        List<ITEM> items = new ArrayList<>();
        for (CheckedListItem<ITEM> checkedItem : mItems) {
            if (checkedItem.isChecked()) {
                items.add(checkedItem.getItem());
            }
        }

        return items;
    }

    private List<CheckedListItem<ITEM>> createCheckedListFromList(List<ITEM> items) {
        List<CheckedListItem<ITEM>> checkedListItems = new ArrayList<>();
        for (ITEM item : items) {
            checkedListItems.add(new CheckedListItem<ITEM>(item));
        }

        return checkedListItems;
    }

    private void clearCheckedItems() {
        for (CheckedListItem<ITEM> item : mItems) {
            item.setChecked(false);
        }
    }

    @Override
    public void onItemClicked(int position, CheckedListItem<ITEM> item) {
        CheckedListItem<ITEM> checkedItem = mItems.get(position);
        checkedItem.setChecked(!checkedItem.isChecked());
    }
}
