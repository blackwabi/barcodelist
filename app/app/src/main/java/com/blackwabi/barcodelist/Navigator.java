package com.blackwabi.barcodelist;

import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.blackwabi.barcodelist.fragments.ArticleListFragment;
import com.blackwabi.barcodelist.fragments.ArticleListListFragment;
import com.blackwabi.barcodelist.fragments.NewArticleFragment;
import com.blackwabi.barcodelist.fragments.NewListFragment;
import com.blackwabi.barcodelist.fragments.NewListNameFragment;

/**
 * Created by martinbegleiter on 04/12/16.
 */

public class Navigator {
    private final AppCompatActivity mActivity;

    public Navigator(AppCompatActivity activity) {
        mActivity = activity;
    }

    public void goToArticles() {
        replaceFragment(new ArticleListFragment(), R.string.articles);
    }

    public void goToLists() {
        replaceFragment(new ArticleListListFragment(), R.string.article_lists);
    }

    public void goToNewArticle() {
        replaceFragment(new NewArticleFragment(), R.string.new_article);
    }

    public void goToNewArticleListName() {
        showDialogFragment(new NewListNameFragment());
    }

    public void goToNewList(String listName) {
        replaceFragment(NewListFragment.newInstance(listName), listName);
    }

    private void replaceFragment(Fragment fragment, String title) {
        replaceFragment(fragment);
        mActivity.setTitle(title);
    }

    private void replaceFragment(Fragment fragment, @StringRes int id) {
        replaceFragment(fragment);
        mActivity.setTitle(id);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = mActivity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_barcode, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showDialogFragment(DialogFragment fragment) {
        fragment.show(mActivity.getSupportFragmentManager(), "dialog");
    }
}
