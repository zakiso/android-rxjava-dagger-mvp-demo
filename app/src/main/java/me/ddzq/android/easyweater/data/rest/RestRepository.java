package me.ddzq.android.easyweater.data.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.inject.Inject;

import me.ddzq.android.easyweater.data.Repository;
import me.ddzq.android.easyweater.data.model.WeatherBean;
import me.ddzq.android.easyweater.data.rest.Exception.NetworkErrorException;
import me.ddzq.android.easyweater.data.rest.Exception.NetworkTimeOutException;
import me.ddzq.android.easyweater.data.rest.Exception.NetworkUknownHostException;
import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import rx.Observable;

/**
 * Created by dzq on 15/7/25.
 */
public class RestRepository implements Repository {

    private WeatherApi mWeatherApi;

    @Inject
    public RestRepository() {
        Gson gson = new GsonBuilder().create();

        RestAdapter weatherApiAdapter = new RestAdapter.Builder()
                .setEndpoint(WeatherApi.END_POINT)
                .setRequestInterceptor(authInterceptor)
                .setConverter(new GsonConverter(gson))
                .setErrorHandler(new MyErrorHandler())
                .build();

        mWeatherApi = weatherApiAdapter.create(WeatherApi.class);
    }


    class MyErrorHandler implements ErrorHandler {
        @Override
        public Throwable handleError(retrofit.RetrofitError cause) {

            if (cause.getKind() == retrofit.RetrofitError.Kind.NETWORK) {

                if (cause.getCause() instanceof SocketTimeoutException)
                    return new NetworkTimeOutException();

                else if (cause.getCause() instanceof UnknownHostException)
                    return new NetworkUknownHostException();

                else if (cause.getCause() instanceof ConnectException)
                    return cause.getCause();

            } else {

                return new NetworkErrorException();
            }

            return new Exception();
        }
    }

    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("https://api.github.com")
            .setErrorHandler(new MyErrorHandler())
            .build();

    RequestInterceptor authInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("apikey",WeatherApi.API_KEY);
        }
    };

    @Override
    public Observable<WeatherBean> getWeather(String citypinyin) {
        return mWeatherApi.getWeather(citypinyin);
    }
}
