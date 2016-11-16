package com.example.kongalong.day27_home_work.presenter;

import com.example.kongalong.day27_home_work.view.MvpView;

/**
 * Created by kongalong on 2016/11/15.
 */

public interface Persenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
