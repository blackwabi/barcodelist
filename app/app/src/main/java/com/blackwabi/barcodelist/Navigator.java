package com.blackwabi.barcodelist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.blackwabi.barcodelist.fragments.ArticleListFragment;
import com.blackwabi.barcodelist.fragments.ArticleListListFragment;
import com.blackwabi.barcodelist.fragments.NewArticleFragment;

/**
 * Created by martinbegleiter on 04/12/16.
 */

public class Navigator {
    private final AppCompatActivity mActivity;

    public Navigator(AppCompatActivity activity) {
        mActivity = activity;
    }

    public void goToArticles() {
        replaceFragment(new ArticleListFragment());
    }

    public void goToLists() {
        replaceFragment(new ArticleListListFragment());
    }

    public void goToNewArticle() {
        replaceFragment(new NewArticleFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = mActivity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_barcode, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
