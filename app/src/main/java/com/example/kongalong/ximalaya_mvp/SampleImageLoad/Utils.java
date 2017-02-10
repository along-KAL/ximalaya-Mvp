package com.example.kongalong.ximalaya_mvp.SampleImageLoad;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.RequiresApi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kongalong on 2016/11/8.
 */

public class Utils {

    //判断是否有SD卡
    public static boolean isMounted(){

        String state = Environment.getExternalStorageState();

        return state.equals(Environment.MEDIA_MOUNTED);

    }
    //获取disk缓存文件夹
    public static File getDiskCacheFile(Context context,String fileName){

        String diskCachepath = null;
        //判断是否挂载sd卡，没有缓存到内置存储
        if(isMounted()){
            diskCachepath = context.getExternalCacheDir().getAbsolutePath();
        }else{
            diskCachepath = context.getCacheDir().getAbsolutePath();
        }

        File file = new File(diskCachepath + File.separator + fileName);

        if(!file.exists()){
            file.mkdirs();
        }

        return file;

    }


    //获取disk可用大小
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getAvailableSpace(File file){


        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.GINGERBREAD){
            return  file.getUsableSpace();

        }

        StatFs statFs = new StatFs(file.getPath());

        return  statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }


    //把路径转换成md5作为key(文件的名字)
    public static String getkeyFromUrl(String url){
        String ret = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = url.getBytes();
            messageDigest.update(bytes);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0XFF & bytes[i]);

                if(hex.length() == 0){
                    sb.append('0');
                }
                sb.append(hex);
            }
            ret = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            ret = String.valueOf(url.hashCode());
        }
        return ret;
    }



    //关流
    public static void closeIs(InputStream is){

        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //关流
    public static void closeOs(OutputStream os){

        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
