package com.samir.wanandroid.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 体系树
 */

public class ArticleTree implements Parcelable {

    /**
     *  "children": [],
     "courseId": 13,
     "id": 150,
     "name": "开发环境",
     "order": 1,
     "parentChapterId": 0,
     "visible": 1
     */

    private List<ArticleTree> children;
    private int courseId;
    private int id;
    private String name;
    private int order;
    private int parentChapterId;
    private int visible;

    public List<ArticleTree> getChildren() {
        return children;
    }

    public void setChildren(List<ArticleTree> children) {
        this.children = children;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.children);
        dest.writeInt(this.courseId);
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.order);
        dest.writeInt(this.parentChapterId);
        dest.writeInt(this.visible);
    }

    public ArticleTree() {
    }

    protected ArticleTree(Parcel in) {
        this.children = in.createTypedArrayList(ArticleTree.CREATOR);
        this.courseId = in.readInt();
        this.id = in.readInt();
        this.name = in.readString();
        this.order = in.readInt();
        this.parentChapterId = in.readInt();
        this.visible = in.readInt();
    }

    public static final Creator<ArticleTree> CREATOR = new Creator<ArticleTree>() {
        @Override
        public ArticleTree createFromParcel(Parcel source) {
            return new ArticleTree(source);
        }

        @Override
        public ArticleTree[] newArray(int size) {
            return new ArticleTree[size];
        }
    };
}
