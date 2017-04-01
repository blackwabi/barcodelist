package com.blackwabi.barcodelist.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.ArticleList;
import com.blackwabi.barcodelist.presenters.CheckedListItem;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public class ArticleListAdapter extends RemovalListAdapter<ArticleList, ArticleListAdapter
        .ArticleListViewHolder> {

    @Override
    protected int getItemLayout() {
        return R.layout.list_item;
    }

    @Override
    protected ArticleListViewHolder initViewHolder(View view) {
        return new ArticleListViewHolder(view);
    }

    @Override
    protected void bindItemToHolder(ArticleListViewHolder holder, CheckedListItem<ArticleList> listitem, boolean removalMode) {
        holder.mListName.setText(listitem.getItem().listName);
        holder.mNumberOfItems.setText(String.valueOf(listitem.getItem().articles.size()));
    }

    public class ArticleListViewHolder extends RecyclerView.ViewHolder {

        private final TextView mListName;
        private final TextView mNumberOfItems;

        public ArticleListViewHolder(View itemView) {
            super(itemView);
            mListName = (TextView)itemView.findViewById(R.id.list_name);
            mNumberOfItems = (TextView)itemView.findViewById(R.id.number_of_items);
        }
    }
}
