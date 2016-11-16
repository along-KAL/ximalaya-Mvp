package com.example.kongalong.day27_home_work.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View ret = inflater.inflate( getLayoutId(), container, false);
        //初始化图片加载工具
        initSampleImageLoad();

        //初始化View和事件
        initViewAndEvent(ret);

        initData();

        return ret;
    }





    //返回layoutId
    protected abstract  int getLayoutId();

    //初始化View
    protected  abstract  void initViewAndEvent(View ret);

    //初始化数据
    protected  abstract  void initData();


    protected  abstract  void initSampleImageLoad();




}
