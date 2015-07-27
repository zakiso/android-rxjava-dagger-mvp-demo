package me.ddzq.android.easyweater.domain;

import rx.Observable;

/**
 * Created by dzq on 15/7/25.
 */
public interface UseCase<T> {
    Observable<T> execute(String cityPinyin);
}
