package com.samir.wanandroid.binding;

import android.content.Context;
import android.databinding.DataBindingComponent;

/**
 * @Description:
 */
public class DefaultBindingComponent implements DataBindingComponent {

    private final DefaultBindingAdapters adapter;

    public DefaultBindingComponent(Context context) {
        this.adapter = new DefaultBindingAdapters(context);
    }

    @Override
    public DefaultBindingAdapters getDefaultBindingAdapters() {
        return adapter;
    }





}
