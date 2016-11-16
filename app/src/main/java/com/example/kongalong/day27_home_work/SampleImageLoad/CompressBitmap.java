package com.example.kongalong.day27_home_work.SampleImageLoad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 *
 * 图片压缩
 *
 * Created by kongalong on 2016/11/7.
 */

public class CompressBitmap {


    /**
     * @param bytes  数据源是byte[]
     * @param width
     * @param height
     * @return
     */
    public static Bitmap compressFromBytes(byte[] bytes,int width, int height){


        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);


       /* if(bytes==null){
            return null;
        }

        BitmapFactory.Options option = new BitmapFactory.Options();
        //第一次采样
        option.inJustDecodeBounds = true;
        Bitmap bitmapNull = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, option);
        //根据采样结果按比例计算最终大小
        option.inSampleSize = calculateSize(option,width,height);
        //二次采样
        option.inJustDecodeBounds = false;
        //返回最终bitmap
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length,option);*/
    }


    //根据采样结果按比例计算最终大小
    private static int calculateSize(BitmapFactory.Options option, int width, int height) {

        //初始化比例
        int sampleSize = 1;
        //获取原始大小
        int RawWidth = option.outWidth;
        int RawHeight = option.outHeight;

        //获取倍数
        int w = width / RawWidth;
        int h = height / RawHeight;

        //计算比例
        while(sampleSize <= w || sampleSize <= h){
            sampleSize *= 2;
        }

        return sampleSize;
    }


}
