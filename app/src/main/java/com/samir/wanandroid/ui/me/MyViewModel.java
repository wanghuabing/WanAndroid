package com.samir.wanandroid.ui.me;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * @Description:
 */
public class MyViewModel  extends AndroidViewModel {

    @Inject
    public MyViewModel(@NonNull Application application) {
        super(application);
    }
}
