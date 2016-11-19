package com.example.kongalong.day27_home_work.presenter;

import android.content.Context;

import com.example.kongalong.day27_home_work.Constants.Constans;
import com.example.kongalong.day27_home_work.Uri.Uri;
import com.example.kongalong.day27_home_work.asynctasks.LoadBytesAsynctask;
import com.example.kongalong.day27_home_work.callbacks.OnBytesCallback;
import com.example.kongalong.day27_home_work.model.ClassifyAdvBeans;
import com.example.kongalong.day27_home_work.model.ClassifyBeans;
import com.example.kongalong.day27_home_work.module.discover.ClassifyFragment;
import com.example.kongalong.day27_home_work.utils.InternetUtil;
import com.example.kongalong.day27_home_work.utils.JsonParseUtil;
import com.example.kongalong.day27_home_work.utils.SdCardUtils;
import com.example.kongalong.day27_home_work.view.MvpView;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kongalong on 2016/11/15.
 */

public class ClassifyFragmentPresenter extends BasePresenter<ClassifyFragment>{

    private Context mContext;

    public ClassifyFragmentPresenter(Context context){
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
    public ClassifyFragment getMvpView() {
        return super.getMvpView();
    }





    public void loadData() {


        //没有联网，从本地获取数据
        if(InternetUtil.isConnnected(mContext)){

            new LoadBytesAsynctask(new OnBytesCallback() {
                @Override
                public void bytesCallback(List<byte[]> listBytes) {

                    SdCardUtils.saveFile(mContext.getExternalCacheDir().getAbsolutePath(), Constans.CLASSIFY_JSON,listBytes.get(0));
                    SdCardUtils.saveFile(mContext.getExternalCacheDir().getAbsolutePath(), Constans.CLASSIFY_ADV_JSON,listBytes.get(1));

                    getMvpView().refleshData(bytesToClassifyBeans(listBytes.get(0))
                            ,bytesToClassifyAdvBeans(listBytes.get(1)));


                }
            }).execute(Uri.CLASSIFY_URL,Uri.CLASSIFY_ADV_URL);

        }else{
            String path = mContext.getExternalCacheDir().getAbsolutePath()+ File.separator;
            byte[] json1 = SdCardUtils.getBytesFromFile(path+Constans.CLASSIFY_JSON);
            byte[] json2 = SdCardUtils.getBytesFromFile(path+Constans.CLASSIFY_ADV_JSON);


            List<byte[]> listBytes = new ArrayList<>();
            listBytes.add(json1);
            listBytes.add(json2);

            if(listBytes.get(0)==null||listBytes.get(1)==null){
                return;
            }
            //刷新view数据
            getMvpView().refleshData(bytesToClassifyBeans(listBytes.get(0))
                    ,bytesToClassifyAdvBeans(listBytes.get(1)));

        }

    }


    private ClassifyBeans bytesToClassifyBeans(byte[] bytes){
        String jsonStr = null;
        try {
            jsonStr = new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return JsonParseUtil.parseJsonToClassifyBeans(jsonStr);

    }

    private ClassifyAdvBeans bytesToClassifyAdvBeans(byte[] bytes){
        String jsonStr = null;
        try {
            jsonStr = new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return JsonParseUtil.parseJsonToClassifyAdvBeans(jsonStr);

    }

}
