package me.ddzq.android.easyweater.injector.components;

import javax.inject.Singleton;

import dagger.Component;
import me.ddzq.android.easyweater.WeatherApplication;
import me.ddzq.android.easyweater.data.Repository;
import me.ddzq.android.easyweater.injector.module.AppModule;

/**
 * Created by dzq on 15/7/26.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    WeatherApplication app();
}
