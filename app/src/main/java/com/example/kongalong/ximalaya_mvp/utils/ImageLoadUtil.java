package com.example.kongalong.ximalaya_mvp.utils;

import android.widget.ImageView;

import com.example.kongalong.ximalaya_mvp.imageLoad.SampleImageLoad;

/**
 * Created by kongalong on 2016/11/17.
 */

public class ImageLoadUtil {

    public static void showImage(SampleImageLoad sampleImageLoad, String path, ImageView imageView){

        sampleImageLoad.initParams()
                .setUrl(path)
                .setImageSize(-1,-1)
                .setImageView(imageView)
                .attachToView();
    }
}
