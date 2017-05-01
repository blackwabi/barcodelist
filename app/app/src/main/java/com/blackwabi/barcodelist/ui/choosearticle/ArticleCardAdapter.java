package com.blackwabi.barcodelist.ui.choosearticle;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.mvp.RemovalListAdapter;
import com.blackwabi.barcodelist.mvp.CheckedListItem;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public class ArticleCardAdapter extends RemovalListAdapter<Article, ArticleCardAdapter.ArticleCardViewHolder> {

    @Override
    protected int getItemLayout() {
        return R.layout.article_card_item;
    }

    @Override
    protected ArticleCardViewHolder initViewHolder(View view) {
        return new ArticleCardViewHolder(view);
    }

    @Override
    protected void bindItemToHolder(ArticleCardViewHolder holder, CheckedListItem<Article> listitem, boolean removalMode) {
        holder.mArticleName.setText(listitem.getItem().articleName);
    }

    public class ArticleCardViewHolder extends RecyclerView.ViewHolder {
        private final TextView mArticleName;

        public ArticleCardViewHolder(View itemView) {
            super(itemView);
            mArticleName = (TextView)itemView.findViewById(R.id.article_name);
        }
    }
}
