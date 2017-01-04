package com.blackwabi.barcodelist.data;

import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.data.model.ArticleList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmList;

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

    public void addArticleList(String listName) {
        final ArticleList articleList = new ArticleList();
        articleList.listName = listName;
        articleList.articles = new RealmList<>();
        mRealm.executeTransaction(realm -> realm.copyToRealmOrUpdate(articleList));
    }

    public void addExistingArticleToExistingList(String listName, Article article) {
        ArticleList list = mRealm.where(ArticleList.class).findFirst();
        list.articles.add(article);
        mRealm.executeTransaction(realm -> realm.copyToRealmOrUpdate(list));
    }

    public List<Article> getArticles() {
        return mRealm.where(Article.class).findAll();
    }

    public List<ArticleList> getArticleLists() {
        return mRealm.where(ArticleList.class).findAll();
    }

    public List<Article> getArticlesInList(String listName) {
        ArticleList articleList = mRealm.where(ArticleList.class).contains("listName", listName)
                .findFirst();
        if (articleList != null) {
            return articleList.articles;
        } else {
            return new ArrayList<>();
        }
    }
}
