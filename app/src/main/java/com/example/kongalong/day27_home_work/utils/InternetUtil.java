package com.example.kongalong.day27_home_work.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by kongalong on 2016/10/28.
 */

public class InternetUtil {

    public static boolean isConnnected(Context context){

       ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo network = manager.getActiveNetworkInfo();
        if(network==null){
            return false;
        }
        int type = network.getType();

        switch(type){
            case ConnectivityManager.TYPE_WIFI:
                return true;

            case ConnectivityManager.TYPE_MOBILE:
                return true;

            default:
                break;
        }
        return false;
    }




}
