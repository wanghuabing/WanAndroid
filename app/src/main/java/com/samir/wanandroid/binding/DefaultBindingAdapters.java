package com.samir.wanandroid.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.samir.framework.utils.SPUtils;

/**
 * @Description:
 */
public  class DefaultBindingAdapters {

    final Context context;

    public DefaultBindingAdapters(Context context) {
        this.context = context;
    }

    @BindingAdapter("imageUrl")
    public void bindImage(ImageView imageView, String url) {
        if(SPUtils.getBoolean(context,"NoImage",true)){
            Glide.with(context).load(url).into(imageView);
        }

    }

}
