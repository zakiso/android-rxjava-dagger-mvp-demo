package me.ddzq.android.easyweater.domain;

import javax.inject.Inject;

import me.ddzq.android.easyweater.data.Repository;
import me.ddzq.android.easyweater.data.model.WeatherBean;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dzq on 15/7/26.
 */
public class GetWeatherUsecase implements UseCase<WeatherBean> {


    private final Repository mRepository;

    @Inject
    public GetWeatherUsecase(Repository mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    public Observable<WeatherBean> execute(String cityPinyin) {
        return mRepository.getWeather(cityPinyin)
                .subscribeOn(Schedulers.io())
                .onErrorResumeNext(Observable.<WeatherBean>empty())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
