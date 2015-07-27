package me.ddzq.android.easyweater.data;

import me.ddzq.android.easyweater.data.model.WeatherBean;
import rx.Observable;

/**
 * Created by dzq on 15/7/25.
 * 数据仓库接口
 */
public interface Repository {
    /**
     * @param citypinyin 城市的拼音作为查询参数
     * @return 返货一个Observable对象
     */
    Observable<WeatherBean> getWeather(String citypinyin);

}
