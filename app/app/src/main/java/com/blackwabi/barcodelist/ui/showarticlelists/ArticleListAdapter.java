package com.blackwabi.barcodelist.ui.showarticlelists;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.ArticleList;
import com.blackwabi.barcodelist.mvp.RemovalListAdapter;
import com.blackwabi.barcodelist.mvp.CheckedListItem;

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
        if (removalMode) {
            holder.mCheckbox.setVisibility(View.VISIBLE);
        } else {
            holder.mCheckbox.setVisibility(View.GONE);
        }
        holder.mCheckbox.setChecked(listitem.isChecked());
    }

    public class ArticleListViewHolder extends RecyclerView.ViewHolder {

        private final TextView mListName;
        private final TextView mNumberOfItems;
        private final CheckBox mCheckbox;

        public ArticleListViewHolder(View itemView) {
            super(itemView);
            mListName = (TextView)itemView.findViewById(R.id.list_name);
            mNumberOfItems = (TextView)itemView.findViewById(R.id.number_of_items);
            mCheckbox = (CheckBox)itemView.findViewById(R.id.check_box);
        }
    }
}
