package com.blackwabi.barcodelist.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{
    public class ListViewHolder extends RecyclerView.ViewHolder {
        private final TextView mListName;

        public ListViewHolder(View itemView) {
            super(itemView);
            mListName = (TextView)itemView.findViewById(R.id.list_name);
        }
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
