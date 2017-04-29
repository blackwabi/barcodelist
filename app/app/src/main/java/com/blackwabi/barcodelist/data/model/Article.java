package com.blackwabi.barcodelist.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by martinbegleiter on 06/12/16.
 */

public class Article extends RealmObject {
    public String articleName;

    @PrimaryKey
    public String articleCode;

    public String photoUri;
}
