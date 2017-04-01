package com.blackwabi.barcodelist.fragments;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public abstract class ListAdapter<LISTITEM, VIEWHOLDER extends RecyclerView.ViewHolder> extends
        RecyclerView.Adapter<VIEWHOLDER> {

    private List<LISTITEM> mItems;
    private ListFragment.ItemClickListener<LISTITEM> mItemClickListener = new ListFragment.ItemClickListener<LISTITEM>() {
        @Override
        public void onItemClicked(int position, LISTITEM listitem) {
            // Do nothing
        }
    };
    private ListFragment.ItemClickListener<LISTITEM> mItemRemoveClickListener = new ListFragment.ItemClickListener<LISTITEM>() {
        @Override
        public void onItemClicked(int position, LISTITEM listitem) {
            // Do nothing
        }
    };

    private boolean mRemovalMode;

    protected abstract @LayoutRes int getItemLayout();

    protected abstract VIEWHOLDER initViewHolder(View view);

    protected abstract void bindItemToHolder(VIEWHOLDER holder, LISTITEM listitem, boolean removalMode);

    public void setList(List<LISTITEM> list) {
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
        final LISTITEM listitem = mItems.get(position);
        bindItemToHolder(holder, listitem, mRemovalMode);
        holder.itemView.setOnClickListener(view -> onItemClicked(position, listitem));
    }

    private void onItemClicked(int position, LISTITEM item) {
        if (mRemovalMode) {
            if (mItemRemoveClickListener != null) {
                mItemRemoveClickListener.onItemClicked(position, item);
            }
        } else {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClicked(position, item);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setOnItemClickListener(ListFragment.ItemClickListener<LISTITEM> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setOnItemRemoveClickListener(ListFragment.ItemClickListener<LISTITEM> itemRemoveClickListener) {
        mItemRemoveClickListener = itemRemoveClickListener;
    }

    public void setRemovalMode(boolean remove) {
        mRemovalMode = remove;
        notifyDataSetChanged();
    }
}
