package com.samir.wanandroid.util;

import android.text.TextUtils;

import com.samir.wanandroid.R;

/**
 * @Description:
 */
public class UIUtil {
    /**
     *  获取首字母
     */
    public static String getStrFirstChat(String str) {
        if(TextUtils.isEmpty(str))
            return "@";
        else
            return str.substring(0, 1);
    }


    /**
     *  获取随机头像背景
     */
    public static int  getHeadColorRandom(int Id){
       int type = Id % 4 ;
       int resId = R.drawable.shape_head_red;
       switch (type){
           case 1:
               resId = R.drawable.shape_head_red;
               break;
           case 2:
               resId = R.drawable.shape_head_red;
               break;
           case 3:
               resId =R.drawable.shape_head_red;
               break;
           case 4:
               resId = R.drawable.shape_head_red;
               break;
       }
        return resId;
    }

}
