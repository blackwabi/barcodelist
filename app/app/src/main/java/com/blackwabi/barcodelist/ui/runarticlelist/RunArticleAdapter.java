package com.blackwabi.barcodelist.ui.runarticlelist;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.mvp.CheckedListItem;
import com.blackwabi.barcodelist.mvp.RemovalListAdapter;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public class RunArticleAdapter extends RemovalListAdapter<Article, RunArticleAdapter.ArticleViewHolder> {

    @Override
    protected int getItemLayout() {
        return R.layout.run_article_item;
    }

    @Override
    protected ArticleViewHolder initViewHolder(View view) {
        return new ArticleViewHolder(view);
    }

    @Override
    protected void bindItemToHolder(ArticleViewHolder holder, CheckedListItem<Article> listitem, boolean removalMode) {
        holder.mArticleName.setText(listitem.getItem().articleName);
        holder.mArticleImage.setImageURI(Uri.parse(listitem.getItem().photoUri));
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        private final TextView mArticleName;
        private final ImageView mArticleImage;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            mArticleName = (TextView)itemView.findViewById(R.id.article_name);
            mArticleImage = (ImageView)itemView.findViewById(R.id.articleImage);
        }
    }
}
