package com.samir.wanandroid.di.component;

import android.app.Application;

import com.samir.wanandroid.WanAndroidApp;
import com.samir.wanandroid.di.module.ApiServiceModule;
import com.samir.wanandroid.di.module.AppModule;
import com.samir.wanandroid.di.module.MainActivityModule;
import com.samir.wanandroid.di.module.MainModule;
import com.samir.wanandroid.net.WebService;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * @ClassName: ${type_name}
 * @Description:${todo}
 * @author: Hbwang
 * @date: ${date} ${time}
 */


@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainModule.class,
        ApiServiceModule.class,
        MainActivityModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }


    WebService getAppApi();

    void inject(WanAndroidApp app);
}
