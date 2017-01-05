package com.blackwabi.barcodelist.fragments;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public abstract class ListAdapter<LISTITEM, VIEWHOLDER extends RecyclerView.ViewHolder> extends
        RecyclerView.Adapter<VIEWHOLDER>{

    private List<LISTITEM> mItems;

    protected abstract @LayoutRes int getItemLayout();

    protected abstract VIEWHOLDER initViewHolder(View view);

    protected abstract void bindItemToHolder(VIEWHOLDER holder, LISTITEM listitem);

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
        bindItemToHolder(holder, mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
