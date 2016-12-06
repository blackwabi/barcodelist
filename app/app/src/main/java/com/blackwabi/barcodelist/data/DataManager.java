package com.blackwabi.barcodelist.data;

import com.blackwabi.barcodelist.data.model.Article;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by martinbegleiter on 27/11/16.
 */

public class DataManager {

    private final Realm mRealm;

    @Inject
    public DataManager() {
        mRealm = Realm.getDefaultInstance();
    }

    public void addArticle(String articleName, String articleCode) {
        final Article article = new Article();
        article.articleName = articleName;
        article.articleCode = articleCode;

        mRealm.executeTransaction(realm -> realm.copyToRealmOrUpdate(article));
    }
}
