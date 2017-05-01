package com.blackwabi.barcodelist.data;

import com.blackwabi.barcodelist.data.model.Article;
import com.blackwabi.barcodelist.data.model.ArticleList;
import com.google.common.base.Preconditions;

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
        Preconditions.checkNotNull(articleName);
        Preconditions.checkNotNull(articleCode);
        final Article article = new Article();
        article.articleName = articleName;
        article.articleCode = articleCode;

        mRealm.executeTransaction(realm -> realm.copyToRealmOrUpdate(article));
    }

    public void addArticleList(String listName) {
        Preconditions.checkNotNull(listName);
        final ArticleList articleList = new ArticleList();
        articleList.listName = listName;
        articleList.articles = new RealmList<>();
        mRealm.executeTransaction(realm -> realm.copyToRealmOrUpdate(articleList));
    }

    public void addExistingArticleToExistingList(String listName, Article article) {
        Preconditions.checkNotNull(listName);
        Preconditions.checkNotNull(article);
        ArticleList list = mRealm.where(ArticleList.class).contains("listName", listName).findFirst();
        mRealm.executeTransaction(realm -> {
            list.articles.add(article);
            realm.copyToRealmOrUpdate(list);
        });
    }

    public List<Article> getArticles() {
        return mRealm.where(Article.class).findAll();
    }

    public List<ArticleList> getArticleLists() {
        return mRealm.where(ArticleList.class).findAll();
    }

    public List<Article> getArticlesInList(String listName) {
        Preconditions.checkNotNull(listName);
        ArticleList articleList = mRealm.where(ArticleList.class).contains("listName", listName)
                .findFirst();
        if (articleList != null) {
            return articleList.articles;
        } else {
            return new ArrayList<>();
        }
    }

    public void removeArticleLists(List<ArticleList> articleLists) {
        mRealm.executeTransaction(realm -> {
            for (ArticleList list : articleLists) {
                list.deleteFromRealm();
            }
        });
    }

    public void removeArticles(List<Article> articles) {
        mRealm.executeTransaction(realm -> {
            for (Article article : articles) {
                article.deleteFromRealm();
            }
        });
    }

    public void removeArticlesFromSpecificList(String listName, List<Article> articles) {
        Preconditions.checkNotNull(listName);
        Preconditions.checkNotNull(articles);
        ArticleList list = mRealm.where(ArticleList.class).contains("listName", listName).findFirst();
        mRealm.executeTransaction(realm -> {
            for (Article article : articles) {
                list.articles.remove(article);
            }
            realm.copyToRealmOrUpdate(list);
        });
    }
}
