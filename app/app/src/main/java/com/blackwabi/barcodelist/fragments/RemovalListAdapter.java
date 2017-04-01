package com.blackwabi.barcodelist.fragments;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.blackwabi.barcodelist.presenters.CheckedListItem;

import java.util.List;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public abstract class RemovalListAdapter<LISTITEM, VIEWHOLDER extends RecyclerView.ViewHolder> extends
        RecyclerView.Adapter<VIEWHOLDER> {

    private List<CheckedListItem<LISTITEM>> mItems;
    private RemovalListFragment.ItemClickListener<LISTITEM> mItemClickListener;
    private RemovalListFragment.ItemClickListener<CheckedListItem<LISTITEM>> mItemRemoveClickListener;

    private boolean mRemovalState;

    protected abstract @LayoutRes int getItemLayout();

    protected abstract VIEWHOLDER initViewHolder(View view);

    protected abstract void bindItemToHolder(VIEWHOLDER holder, CheckedListItem<LISTITEM> listitem, boolean removalMode);

    public void setList(List<CheckedListItem<LISTITEM>> list) {
        mItems = list;
        notifyDataSetChanged();
    }

    @Override
    public VIEWHOLDER onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getItemLayout(), parent, false);
        return initViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VIEWHOLDER holder, int position) {
        final CheckedListItem<LISTITEM> checkedListItem = mItems.get(position);
        bindItemToHolder(holder, checkedListItem, mRemovalState);
        holder.itemView.setOnClickListener(view -> onItemClicked(position, checkedListItem));
    }

    private void onItemClicked(int position, CheckedListItem<LISTITEM> item) {
        if (mRemovalState) {
            if (mItemRemoveClickListener != null) {
                mItemRemoveClickListener.onItemClicked(position, item);
            }
        } else {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClicked(position, item.getItem());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setOnItemClickListener(RemovalListFragment.ItemClickListener<LISTITEM> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setOnItemRemoveClickListener(RemovalListFragment.ItemClickListener<CheckedListItem<LISTITEM>> itemRemoveClickListener) {
        mItemRemoveClickListener = itemRemoveClickListener;
    }

    public void setRemovalState(boolean remove) {
        mRemovalState = remove;
        notifyDataSetChanged();
    }
}
