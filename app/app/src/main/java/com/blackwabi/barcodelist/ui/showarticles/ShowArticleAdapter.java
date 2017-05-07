package com.blackwabi.barcodelist.ui.showarticles;

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

public class ShowArticleAdapter extends RemovalListAdapter<Article, ShowArticleAdapter.ArticleCardViewHolder> {

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
        holder.mArticleImage.setImageURI(Uri.parse(listitem.getItem().photoUri));
        if (removalMode) {
            holder.mCheckbox.setVisibility(View.VISIBLE);
        } else {
            holder.mCheckbox.setVisibility(View.GONE);
        }
        holder.mCheckbox.setChecked(listitem.isChecked());
    }

    public class ArticleCardViewHolder extends RecyclerView.ViewHolder {
        private final TextView mArticleName;
        private final ImageView mArticleImage;
        private final CheckBox mCheckbox;

        public ArticleCardViewHolder(View itemView) {
            super(itemView);
            mArticleName = (TextView)itemView.findViewById(R.id.article_name);
            mArticleImage = (ImageView)itemView.findViewById(R.id.articleImage);
            mCheckbox = (CheckBox)itemView.findViewById(R.id.check_box);
        }
    }
}
