package com.example.kongalong.day27_home_work.presenter;

import android.content.Context;

import com.example.kongalong.day27_home_work.Uri.Uri;
import com.example.kongalong.day27_home_work.asynctasks.LoadBytesAsynctask;
import com.example.kongalong.day27_home_work.callbacks.OnBytesCallback;
import com.example.kongalong.day27_home_work.module.discover.RecommendFragment;
import com.example.kongalong.day27_home_work.utils.InternetUtil;
import com.example.kongalong.day27_home_work.utils.SdCardUtils;
import com.example.kongalong.day27_home_work.view.MvpView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kongalong on 2016/11/15.
 */

public class RecommendFragmentPresenter extends BasePresenter<RecommendFragment> {

    private Context mContext;

    public RecommendFragmentPresenter(Context context){
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
    public RecommendFragment getMvpView() {
        return super.getMvpView();
    }





    public void loadData() {


        //没有联网，从本地获取数据
        if(InternetUtil.isConnnected(mContext)){

            new LoadBytesAsynctask(new OnBytesCallback() {
                @Override
                public void bytesCallback(List<byte[]> listBytes) {

                    SdCardUtils.saveFile(mContext.getExternalCacheDir().getAbsolutePath(),"json1",listBytes.get(0));
                    SdCardUtils.saveFile(mContext.getExternalCacheDir().getAbsolutePath(),"json2",listBytes.get(1));
                    SdCardUtils.saveFile(mContext.getExternalCacheDir().getAbsolutePath(),"json3",listBytes.get(2));

                    getMvpView().refleshData(listBytes);


                }
            }).execute(
                    Uri.discoverRecommend1,
                    Uri.discoverRecommend2,
                    Uri.discoverRecommend3);

        }else{
            String path = mContext.getExternalCacheDir().getAbsolutePath()+ File.separator;
            byte[] json1 = SdCardUtils.getBytesFromFile(path+"json1");
            byte[] json2 = SdCardUtils.getBytesFromFile(path+"json2");
            byte[] json3 = SdCardUtils.getBytesFromFile(path+"json3");


            List<byte[]> listBytes = new ArrayList<>();
            listBytes.add(json1);
            listBytes.add(json2);
            listBytes.add(json3);
            //刷新view数据
            getMvpView().refleshData(listBytes);

        }

    }







}
