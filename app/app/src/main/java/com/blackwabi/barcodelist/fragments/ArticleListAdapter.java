package com.blackwabi.barcodelist.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.ArticleList;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public class ArticleListAdapter extends ListAdapter<ArticleList, ArticleListAdapter
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
    protected void bindItemToHolder(ArticleListViewHolder holder, ArticleList articleList) {
        holder.mListName.setText(articleList.listName);
    }

    public class ArticleListViewHolder extends RecyclerView.ViewHolder {

        private final TextView mListName;

        public ArticleListViewHolder(View itemView) {
            super(itemView);
            mListName = (TextView)itemView.findViewById(R.id.list_name);
        }
    }
}