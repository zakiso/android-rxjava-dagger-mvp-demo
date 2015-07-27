package me.ddzq.android.easyweater.presentation.view;

import me.ddzq.android.easyweater.data.model.WeatherBean;

/**
 * Created by dzq on 15/7/26.
 */
public interface WeatherView extends View {

    void showWeatherView(WeatherBean weatherBean);

}
