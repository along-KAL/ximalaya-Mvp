package com.example.kongalong.day27_home_work.view;

import java.util.List;

/**
 * Created by kongalong on 2016/11/15.
 */

public interface RecommendListViewView extends MvpView{

    void refleshData(List<byte[]> datas);

}
