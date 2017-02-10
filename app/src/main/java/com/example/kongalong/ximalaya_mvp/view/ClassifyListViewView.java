package com.example.kongalong.ximalaya_mvp.view;

import com.example.kongalong.ximalaya_mvp.model.ClassifyAdvBeans;
import com.example.kongalong.ximalaya_mvp.model.ClassifyBeans;

/**
 * Created by kongalong on 2016/11/17.
 */

public interface ClassifyListViewView extends MvpView {

    void refleshData(ClassifyBeans classifyBeans,ClassifyAdvBeans classifyAdvBeans);
}
