package com.example.kongalong.day27_home_work.view;

import com.example.kongalong.day27_home_work.model.RecommendBeans1;
import com.example.kongalong.day27_home_work.model.RecommendBeans2;
import com.example.kongalong.day27_home_work.model.RecommendBeans3;

/**
 * Created by kongalong on 2016/11/15.
 */

public interface RecommendListViewView extends MvpView{

    void refleshData(RecommendBeans1 recommendBeans1
            , RecommendBeans2 recommendBeans2, RecommendBeans3 recommendBeans3);

}
