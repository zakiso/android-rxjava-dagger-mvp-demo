package me.ddzq.android.easyweater.data;

import me.ddzq.android.easyweater.data.model.WeatherBean;
import rx.Observable;

/**
 * Created by dzq on 15/7/25.
 */
public interface Repository {

    Observable<WeatherBean> getWeather(String citypinyin);

}
