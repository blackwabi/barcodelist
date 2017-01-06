package com.blackwabi.barcodelist;

import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.blackwabi.barcodelist.fragments.CreateListFragment;
import com.blackwabi.barcodelist.fragments.ShowArticlesFragment;
import com.blackwabi.barcodelist.fragments.CreateArticleFragment;
import com.blackwabi.barcodelist.fragments.ShowArticleListsFragment;
import com.blackwabi.barcodelist.fragments.UseArticleListFragment;

/**
 * Created by martinbegleiter on 04/12/16.
 */

public class Navigator {
    private final AppCompatActivity mActivity;

    public Navigator(AppCompatActivity activity) {
        mActivity = activity;
    }

    public void goToArticles() {
        replaceFragment(new ShowArticlesFragment(), R.string.articles);
    }

    public void goToLists() {
        replaceFragment(new ShowArticleListsFragment(), R.string.article_lists);
    }

    public void goToCreateArticle() {
        replaceFragment(new CreateArticleFragment(), R.string.new_article);
    }

    public void goToCreateList() {
        showDialogFragment(new CreateListFragment());
    }

    public void goToList(String listName) {
        replaceFragment(UseArticleListFragment.newInstance(listName), listName);
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
