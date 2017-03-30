package com.blackwabi.barcodelist.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public class ArticleCardAdapter extends ListAdapter<Article, ArticleCardAdapter.ArticleCardViewHolder> {

    @Override
    protected int getItemLayout() {
        return R.layout.article_card_item;
    }

    @Override
    protected ArticleCardViewHolder initViewHolder(View view) {
        return new ArticleCardViewHolder(view);
    }

    @Override
    protected void bindItemToHolder(ArticleCardViewHolder holder, Article article) {
        holder.mArticleName.setText(article.articleName);
    }

    public class ArticleCardViewHolder extends RecyclerView.ViewHolder {
        private final TextView mArticleName;

        public ArticleCardViewHolder(View itemView) {
            super(itemView);
            mArticleName = (TextView)itemView.findViewById(R.id.article_name);
        }
    }
}
