package me.ddzq.android.easyweater.presentation.presenter;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

import me.ddzq.android.easyweater.data.model.WeatherBean;
import me.ddzq.android.easyweater.domain.GetWeatherUsecase;
import me.ddzq.android.easyweater.presentation.view.View;
import me.ddzq.android.easyweater.presentation.view.WeatherView;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by dzq on 15/7/26.
 */
public class WeatherPresenter implements Presenter {

    private WeatherBean weatherBean;
    private final Context context;
    private WeatherView mWeatherView;

    private final GetWeatherUsecase mGetWeatherUsecase;

    @Inject
    public WeatherPresenter(Context context, GetWeatherUsecase mGetWeatherUsecase) {
        this.context = context;
        this.mGetWeatherUsecase = mGetWeatherUsecase;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void attachView(View v) {
        mWeatherView = (WeatherView) v;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void btnClick(String cityPinyin) {
        Observable<WeatherBean> observable = mGetWeatherUsecase.execute(cityPinyin);

        observable.subscribe(s -> {
            weatherBean = s;
            mWeatherView.showWeatherView(weatherBean);
        });
    }
}
