package me.ddzq.android.easyweater.presentation.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import me.ddzq.android.easyweater.R;
import me.ddzq.android.easyweater.WeatherApplication;
import me.ddzq.android.easyweater.data.model.WeatherBean;
import me.ddzq.android.easyweater.injector.components.DaggerWeatherComponent;
import me.ddzq.android.easyweater.injector.module.ActivityModule;
import me.ddzq.android.easyweater.injector.module.WeatherModule;
import me.ddzq.android.easyweater.presentation.presenter.WeatherPresenter;
import me.ddzq.android.easyweater.presentation.view.WeatherView;

public class WeatherActivity extends AppCompatActivity implements WeatherView {

    @Inject
    WeatherPresenter weatherPresenter;

    @InjectView(R.id.input_city_et)
    EditText cityPinyinEt;

    @InjectView(R.id.weather_tv)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initializeDependencyInjector();
        initializePresenter();
    }

    private void initializeDependencyInjector() {

        WeatherApplication weatherApplication = (WeatherApplication) getApplication();

        DaggerWeatherComponent.builder()
                .activityModule(new ActivityModule(this))
                .weatherModule(new WeatherModule())
                .appComponent(weatherApplication.getAppcomnent())
                .build().inject(this);
    }

    @OnClick(R.id.query_btn)
    public void queryWeather(View view) {
        weatherPresenter.btnClick(cityPinyinEt.getText().toString());
    }

    private void initializePresenter() {
        weatherPresenter.attachView(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showWeatherView(WeatherBean weatherBean) {
        textView.setText(weatherBean.toString());
    }
}
