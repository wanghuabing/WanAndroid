package com.samir.wanandroid.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.samir.wanandroid.db.utils.ListTypeConverters;

import java.util.List;

/**
 * @author quchao
 * @date 2018/2/26
 */
@Entity(tableName = "user_table")
@TypeConverters(ListTypeConverters.class)
public class User {

    @PrimaryKey
    @NonNull
    private String username;
    private String password;
    private String icon;
    private int type;
    private List<Integer> collectIds;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Integer> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<Integer> collectIds) {
        this.collectIds = collectIds;
    }
}
