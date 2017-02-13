package com.example.kongalong.ximalaya_mvp;

import android.app.Application;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.kongalong.ximalaya_mvp.imageLoad.SampleImageLoad;

/**
 * Created by kongalong on 2016/11/15.
 */

public class MyApp extends Application {

    public SampleImageLoad getSampleImageLoad() {
        return mSampleImageLoad;
    }

    private SampleImageLoad mSampleImageLoad ;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onCreate() {
        super.onCreate();

        mSampleImageLoad = new SampleImageLoad(this);

    }
}
