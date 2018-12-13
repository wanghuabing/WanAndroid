package com.samir.wanandroid.ui.project;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * @Description:
 */
public class ProjectViewModel  extends AndroidViewModel{


    @Inject
    public ProjectViewModel(@NonNull Application application) {
        super(application);
    }
}
