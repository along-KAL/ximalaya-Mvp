package com.example.kongalong.day27_home_work.asynctasks;

import android.os.AsyncTask;

import com.example.kongalong.day27_home_work.callbacks.OnBytesCallback;
import com.example.kongalong.day27_home_work.utils.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kongalong on 2016/11/10.
 */

public class LoadBytesAsynctask extends AsyncTask<String,Void,List<byte[]>> {

    OnBytesCallback mOnBytesCallback;

    public LoadBytesAsynctask( OnBytesCallback onBytesCallback){

        this.mOnBytesCallback = onBytesCallback;

    }

    @Override
    protected List<byte[]> doInBackground(String... params) {

        List<byte[]> listBytes = new ArrayList<>();
        for (int i = 0;i<params.length;i++) {
            listBytes.add(HttpUtil.loadBytes(params[i]));
        }
        return listBytes;
    }

    @Override
    protected void onPostExecute(List<byte[]> listBytes) {
        super.onPostExecute(listBytes);

        mOnBytesCallback.bytesCallback(listBytes);

    }
}
