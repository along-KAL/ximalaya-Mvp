package com.example.kongalong.ximalaya_mvp.presenter;

import android.content.Context;

import com.example.kongalong.ximalaya_mvp.constants.Constans;
import com.example.kongalong.ximalaya_mvp.uri.Uri;
import com.example.kongalong.ximalaya_mvp.asynctasks.LoadBytesAsynctask;
import com.example.kongalong.ximalaya_mvp.callbacks.OnBytesCallback;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans1;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans2;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans3;
import com.example.kongalong.ximalaya_mvp.module.discover.RecommendFragment;
import com.example.kongalong.ximalaya_mvp.utils.InternetUtil;
import com.example.kongalong.ximalaya_mvp.utils.JsonParseUtil;
import com.example.kongalong.ximalaya_mvp.utils.SdCardUtils;
import com.example.kongalong.ximalaya_mvp.view.MvpView;

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

                    SdCardUtils.saveFile(mContext.getExternalCacheDir().getAbsolutePath(), Constans.RECOMMEND_JSON1,listBytes.get(0));
                    SdCardUtils.saveFile(mContext.getExternalCacheDir().getAbsolutePath(), Constans.RECOMMEND_JSON2,listBytes.get(1));
                    SdCardUtils.saveFile(mContext.getExternalCacheDir().getAbsolutePath(), Constans.RECOMMEND_JSON3,listBytes.get(2));

                    String jsonStr1 = null;
                    String jsonStr2 = null;
                    String jsonStr3 = null;
                    //数据为空直接返回
                    if(listBytes.get(0)==null||listBytes.get(1)==null||listBytes.get(2)==null){
                        return;
                    }
                    jsonStr1 = new String(listBytes.get(0));
                    jsonStr2 = new String(listBytes.get(1));
                    jsonStr3 = new String(listBytes.get(2));

                    RecommendBeans1 recommendBeans1 = JsonParseUtil
                            .parseJsonToRecommendBeans1(jsonStr1);
                    RecommendBeans2 recommendBeans2 = JsonParseUtil
                            .parseJsonToRecommendBeans2(jsonStr2);
                    RecommendBeans3 recommendBeans3 = JsonParseUtil
                            .parseJsonToRecommendBeans3(jsonStr3);

                    getMvpView().refleshData(recommendBeans1,recommendBeans2,recommendBeans3);

                }
            }).execute(
                    Uri.DISCOVERRECOMMEND_URL1,
                    Uri.DISCOVERRECOMMEND_URL2,
                    Uri.DISCOVERRECOMMEND_URL3);

        }else{
            String path = mContext.getExternalCacheDir().getAbsolutePath()+ File.separator;
            byte[] json1 = SdCardUtils.getBytesFromFile(path+ Constans.RECOMMEND_JSON1);
            byte[] json2 = SdCardUtils.getBytesFromFile(path+ Constans.RECOMMEND_JSON2);
            byte[] json3 = SdCardUtils.getBytesFromFile(path+ Constans.RECOMMEND_JSON3);


            List<byte[]> listBytes = new ArrayList<>();
            listBytes.add(json1);
            listBytes.add(json2);
            listBytes.add(json3);


            String jsonStr1 = null;
            String jsonStr2 = null;
            String jsonStr3 = null;
            //数据为空直接返回
            if(listBytes.get(0)==null||listBytes.get(1)==null||listBytes.get(2)==null){
                return;
            }
            jsonStr1 = new String(listBytes.get(0));
            jsonStr2 = new String(listBytes.get(1));
            jsonStr3 = new String(listBytes.get(2));




            RecommendBeans1 recommendBeans1 = JsonParseUtil
                    .parseJsonToRecommendBeans1(jsonStr1);
            RecommendBeans2 recommendBeans2 = JsonParseUtil
                    .parseJsonToRecommendBeans2(jsonStr2);
            RecommendBeans3 recommendBeans3 = JsonParseUtil
                    .parseJsonToRecommendBeans3(jsonStr3);


            //刷新view数据
            getMvpView().refleshData(recommendBeans1,recommendBeans2,recommendBeans3);

        }

    }



}
