package com.samir.wanandroid.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author: samir
 * @date: 2018/12/18 下午4:57
 */
@Entity(tableName = "wx_article_titles_table")
public class WxArticleTitle implements Parcelable {
    /**
     * children : []
     * courseId : 13
     * id : 408
     * name : 鸿洋
     * order : 190000
     * parentChapterId : 407
     * userControlSetTop : false
     * visible : 1
     */
    @PrimaryKey
    private int id;
    private int courseId;
    private String name;
    private int order;
    private int parentChapterId;
    private boolean userControlSetTop;
    private int visible;

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

    public boolean isUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
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
        dest.writeInt(this.id);
        dest.writeInt(this.courseId);
        dest.writeString(this.name);
        dest.writeInt(this.order);
        dest.writeInt(this.parentChapterId);
        dest.writeByte(this.userControlSetTop ? (byte) 1 : (byte) 0);
        dest.writeInt(this.visible);
    }

    public WxArticleTitle() {
    }

    protected WxArticleTitle(Parcel in) {
        this.id = in.readInt();
        this.courseId = in.readInt();
        this.name = in.readString();
        this.order = in.readInt();
        this.parentChapterId = in.readInt();
        this.userControlSetTop = in.readByte() != 0;
        this.visible = in.readInt();
    }

    public static final Creator<WxArticleTitle> CREATOR = new Creator<WxArticleTitle>() {
        @Override
        public WxArticleTitle createFromParcel(Parcel source) {
            return new WxArticleTitle(source);
        }

        @Override
        public WxArticleTitle[] newArray(int size) {
            return new WxArticleTitle[size];
        }
    };
}
