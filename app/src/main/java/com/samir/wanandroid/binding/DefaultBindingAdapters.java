package com.samir.wanandroid.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * @Description:
 */
public  class DefaultBindingAdapters {

    final Context context;

    public DefaultBindingAdapters(Context context) {
        this.context = context;
    }

    @BindingAdapter("imageUrl")
    public  void bindImage(ImageView imageView, String url){

    }


}
