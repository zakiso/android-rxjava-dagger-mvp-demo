package me.ddzq.android.easyweater.injector.module;

import dagger.Module;
import dagger.Provides;
import me.ddzq.android.easyweater.data.Repository;
import me.ddzq.android.easyweater.domain.GetWeatherUsecase;
import me.ddzq.android.easyweater.injector.PerActivity;

/**
 * Created by dzq on 15/7/26.
 */

@Module
public class WeatherModule {
    
    @Provides
    @PerActivity
    GetWeatherUsecase provideGetWeatherUsecase(Repository repository) {
        return new GetWeatherUsecase(repository);
    }

}
