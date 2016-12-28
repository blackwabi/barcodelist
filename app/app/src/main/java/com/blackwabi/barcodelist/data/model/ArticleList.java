package com.blackwabi.barcodelist.data.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by martinbegleiter on 06/12/16.
 */

public class ArticleList extends RealmObject {

    @PrimaryKey
    public String listName;

    public RealmList<Article> articles;
}
