package com.example.kongalong.day27_home_work.utils;

import android.widget.ImageView;

import com.example.kongalong.day27_home_work.SampleImageLoad.SampleImageLoad;

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
