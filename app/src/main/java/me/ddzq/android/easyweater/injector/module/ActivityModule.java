package me.ddzq.android.easyweater.injector.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import me.ddzq.android.easyweater.data.Repository;
import me.ddzq.android.easyweater.data.rest.RestRepository;
import me.ddzq.android.easyweater.injector.PerActivity;

/**
 * Created by dzq on 15/7/26.
 */
@Module
public class ActivityModule {
    private final Context mContext;


    public ActivityModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @PerActivity
    Context provideActivityContext() {
        return mContext;
    }

    @Provides
    @PerActivity
    Repository provideRestRepository(RestRepository repository) {
        return repository;
    }
}
