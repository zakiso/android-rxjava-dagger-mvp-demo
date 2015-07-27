package me.ddzq.android.easyweater.injector.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.ddzq.android.easyweater.WeatherApplication;

/**
 * Created by dzq on 15/7/26.
 */
@Module
public class AppModule {

    private final WeatherApplication weatherApplication;

    public AppModule(WeatherApplication weatherApplication) {
        this.weatherApplication = weatherApplication;
    }

    @Provides
    @Singleton
    WeatherApplication provideWeatherApplicationContext() {
        return weatherApplication;
    }
}
