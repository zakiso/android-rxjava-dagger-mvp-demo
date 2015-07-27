package me.ddzq.android.easyweater.injector.components;

import android.content.Context;

import dagger.Component;
import me.ddzq.android.easyweater.data.Repository;
import me.ddzq.android.easyweater.injector.PerActivity;
import me.ddzq.android.easyweater.injector.module.ActivityModule;
import me.ddzq.android.easyweater.presentation.ui.WeatherActivity;

/**
 * Created by dzq on 15/7/26.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


    Context context();

    Repository restRepository();


}
