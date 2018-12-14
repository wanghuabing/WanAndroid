package com.samir.wanandroid.entity;


import java.io.Serializable;
import java.util.List;

/**
 * 文章分类列表
 */
public class TitleArticleList implements Serializable {

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
}
