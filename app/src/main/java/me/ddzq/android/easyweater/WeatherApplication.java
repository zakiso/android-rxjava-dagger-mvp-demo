package me.ddzq.android.easyweater;

import android.app.Application;

import me.ddzq.android.easyweater.injector.components.AppComponent;
import me.ddzq.android.easyweater.injector.components.DaggerAppComponent;
import me.ddzq.android.easyweater.injector.module.AppModule;

/**
 * Created by dzq on 15/7/26.
 */
public class WeatherApplication extends Application {

    private AppComponent mAppcomnent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        mAppcomnent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppcomnent() {
        return mAppcomnent;
    }
}
