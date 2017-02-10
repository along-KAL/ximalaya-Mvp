package com.example.kongalong.ximalaya_mvp.presenter;

import com.example.kongalong.ximalaya_mvp.view.MvpView;

/**
 * Created by kongalong on 2016/11/15.
 */

public class BasePresenter<T extends MvpView> implements Persenter{

    private T mMvpView;

    @Override
    public void attachView(MvpView mvpView) {
        this.mMvpView = (T) mvpView;
    }

    @Override
    public void detachView() {

    }


    public T getMvpView() {
        return mMvpView;
    }



}
