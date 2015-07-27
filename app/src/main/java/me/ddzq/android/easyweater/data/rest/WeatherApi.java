package me.ddzq.android.easyweater.data.rest;


import me.ddzq.android.easyweater.data.model.WeatherBean;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by dzq on 15/7/25.
 */
public interface WeatherApi {

    public final String END_POINT = "http://apis.baidu.com/";
    public final String API_KEY = "143b56c0cc3672794428e22b3d765952";

    @GET("/apistore/weatherservice/weather")
    Observable<WeatherBean> getWeather(@Query("citypinyin") String cityPinYin);

}
