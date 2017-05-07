package com.blackwabi.barcodelist.ui.choosearticle;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.mvp.RemovalListAdapter;
import com.blackwabi.barcodelist.mvp.CheckedListItem;

/**
 * Created by martinbegleiter on 25/11/16.
 */

public class ChooseArticleAdapter extends RemovalListAdapter<Article, ChooseArticleAdapter.ArticleCardViewHolder> {

    @Override
    protected int getItemLayout() {
        return R.layout.choose_article_card_item;
    }

    @Override
    protected ArticleCardViewHolder initViewHolder(View view) {
        return new ArticleCardViewHolder(view);
    }

    @Override
    protected void bindItemToHolder(ArticleCardViewHolder holder, CheckedListItem<Article> listitem, boolean removalMode) {
        holder.mArticleName.setText(listitem.getItem().articleName);
        holder.mArticleImage.setImageURI(Uri.parse(listitem.getItem().photoUri));
    }

    public class ArticleCardViewHolder extends RecyclerView.ViewHolder {
        private final TextView mArticleName;
        private final ImageView mArticleImage;

        public ArticleCardViewHolder(View itemView) {
            super(itemView);
            mArticleName = (TextView)itemView.findViewById(R.id.article_name);
            mArticleImage = (ImageView)itemView.findViewById(R.id.articleImage);
        }
    }
}
