package com.example.kongalong.ximalaya_mvp.presenter;

import com.example.kongalong.ximalaya_mvp.view.MvpView;

/**
 * Created by kongalong on 2016/11/15.
 */

public interface Persenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();

}
