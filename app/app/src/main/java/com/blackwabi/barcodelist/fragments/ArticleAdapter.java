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

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{
    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        private final TextView mArticleName;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            mArticleName = (TextView)itemView.findViewById(R.id.article_name);
        }
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
