package com.example.kongalong.ximalaya_mvp.utils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.kongalong.ximalaya_mvp.R;
import com.example.kongalong.ximalaya_mvp.SampleImageLoad.SampleImageLoad;
import com.example.kongalong.ximalaya_mvp.widget.CustomIndicator;

import java.util.List;

/**
 * Created by kongalong on 2016/11/17.
 */

public class ViewPagerUtil {

    //根据数据动态生成相应数量pager
    public static void refleshPagerData(Context context, List<String> imageUrls
            , List<View> pagerData, CustomIndicator customIndicator
            , SampleImageLoad sampleImageLoad, PagerAdapter adapter) {

        if (pagerData == null) {
            return ;
        }
        int value = imageUrls.size() - pagerData.size();
        if(value>0){
            for (int i = 0; i < value; i++) {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.mipmap.ic_launcher);
                pagerData.add(imageView);
            }
        }else if(value<0){
            for (int i = 0; i < Math.abs(value); i++) {
                pagerData.remove(pagerData.size()-1);
            }
        }

        customIndicator.setCount(pagerData.size());

        for (int i = 0; i < pagerData.size(); i++) {
            ImageLoadUtil.showImage(sampleImageLoad,imageUrls.get(i),(ImageView) pagerData.get(i));
        }

        adapter.notifyDataSetChanged();
    }

}
