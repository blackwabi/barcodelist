package com.blackwabi.barcodelist;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.blackwabi.barcodelist.fragments.ChooseArticleFragment;
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
        replaceFragment(new ShowArticlesFragment());
    }

    public void goToLists() {
        replaceFragment(new ShowArticleListsFragment());
    }

    public void goToCreateArticle() {
        replaceFragment(new CreateArticleFragment());
    }

    public void goToCreateList() {
        showDialogFragment(new CreateListFragment());
    }

    public void goToList(String listName) {
        replaceFragment(UseArticleListFragment.newInstance(listName));
    }

    public void goToChooseArticle(String listName) {
        replaceFragment(ChooseArticleFragment.newInstance(listName));
    }

    public void goBack() {
        mActivity.getSupportFragmentManager().popBackStack();
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
