package com.example.kongalong.ximalaya_mvp.presenter;

import android.content.Context;

import com.example.kongalong.ximalaya_mvp.Constants.Constans;
import com.example.kongalong.ximalaya_mvp.Uri.Uri;
import com.example.kongalong.ximalaya_mvp.asynctasks.LoadBytesAsynctask;
import com.example.kongalong.ximalaya_mvp.callbacks.OnBytesCallback;
import com.example.kongalong.ximalaya_mvp.model.BroadcastBeans;
import com.example.kongalong.ximalaya_mvp.module.discover.BroadcastFragment;
import com.example.kongalong.ximalaya_mvp.utils.InternetUtil;
import com.example.kongalong.ximalaya_mvp.utils.JsonParseUtil;
import com.example.kongalong.ximalaya_mvp.utils.SdCardUtils;
import com.example.kongalong.ximalaya_mvp.view.MvpView;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kongalong on 2016/11/18.
 */
public class BroadcastFragmentPresenter extends BasePresenter<BroadcastFragment>{

    private Context mContext;

    public BroadcastFragmentPresenter(Context context){
        this.mContext = context;

    }

    @Override
    public void attachView(MvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }


    @Override
    public BroadcastFragment getMvpView() {
        return super.getMvpView();
    }





    public void loadData() {


        //没有联网，从本地获取数据
        if(InternetUtil.isConnnected(mContext)){

            new LoadBytesAsynctask(new OnBytesCallback() {
                @Override
                public void bytesCallback(List<byte[]> listBytes) {

                    SdCardUtils.saveFile(mContext.getExternalCacheDir()
                            .getAbsolutePath(), Constans.BROADCAST_JSON,listBytes.get(0));

                    getMvpView().refleshData(bytesToBroadcastBeans(listBytes.get(0)));

                }

            }).execute(Uri.BROADCAST_URL);

        }else{
            String path = mContext.getExternalCacheDir().getAbsolutePath()+ File.separator;
            byte[] json1 = SdCardUtils.getBytesFromFile(path+Constans.BROADCAST_JSON);


            List<byte[]> listBytes = new ArrayList<>();
            listBytes.add(json1);

            if(listBytes.get(0)==null){
                return;
            }
            //刷新view数据
            getMvpView().refleshData(bytesToBroadcastBeans(listBytes.get(0)));

        }

    }

    private BroadcastBeans bytesToBroadcastBeans(byte[] bytes) {
        String jsonStr = null;
        try {
            jsonStr = new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return JsonParseUtil.parseJsonToBroadcastBeans(jsonStr);

    }


}
