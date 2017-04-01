package com.blackwabi.barcodelist.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public class ArticleAdapter extends ListAdapter<Article, ArticleAdapter.ArticleViewHolder> {

    @Override
    protected int getItemLayout() {
        return R.layout.article_item;
    }

    @Override
    protected ArticleViewHolder initViewHolder(View view) {
        return new ArticleViewHolder(view);
    }

    @Override
    protected void bindItemToHolder(ArticleViewHolder holder, Article article, boolean removalMode) {
        holder.mArticleName.setText(article.articleName);
        holder.mArticleCode.setText(article.articleCode);
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        private final TextView mArticleName;
        private final TextView mArticleCode;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            mArticleCode = (TextView)itemView.findViewById(R.id.article_code);
            mArticleName = (TextView)itemView.findViewById(R.id.article_name);
        }
    }
}
