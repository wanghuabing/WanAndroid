package com.samir.wanandroid.entity;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 文章分类列表
 */
public class WxArticleList implements Parcelable {

    /**
     * "articles": [],
     * "cid": 272,
     * "name": "常用网站"
     */

    private List<Article> articles;
    private int cid;
    private String name;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.articles);
        dest.writeInt(this.cid);
        dest.writeString(this.name);
    }

    public WxArticleList() {
    }

    protected WxArticleList(Parcel in) {
        this.articles = in.createTypedArrayList(Article.CREATOR);
        this.cid = in.readInt();
        this.name = in.readString();
    }

    public static final Creator<WxArticleList> CREATOR = new Creator<WxArticleList>() {
        @Override
        public WxArticleList createFromParcel(Parcel source) {
            return new WxArticleList(source);
        }

        @Override
        public WxArticleList[] newArray(int size) {
            return new WxArticleList[size];
        }
    };
}
