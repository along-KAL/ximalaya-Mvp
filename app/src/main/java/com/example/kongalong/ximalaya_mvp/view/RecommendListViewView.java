package com.example.kongalong.ximalaya_mvp.view;

import com.example.kongalong.ximalaya_mvp.model.RecommendBeans1;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans2;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans3;

/**
 * Created by kongalong on 2016/11/15.
 */

public interface RecommendListViewView extends MvpView{

    void refleshData(RecommendBeans1 recommendBeans1
            , RecommendBeans2 recommendBeans2, RecommendBeans3 recommendBeans3);

}
