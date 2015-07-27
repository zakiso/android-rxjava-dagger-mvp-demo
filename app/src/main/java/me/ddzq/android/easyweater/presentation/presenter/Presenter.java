package me.ddzq.android.easyweater.presentation.presenter;

import android.content.Intent;

import me.ddzq.android.easyweater.presentation.view.View;

/**
 * Created by dzq on 15/7/26.
 */
public interface Presenter {
    void onStart();

    void onStop();

    void attachView(View v);

    void attachIncomingIntent(Intent intent);
}
