package com.example.kongalong.day27_home_work.view;

import com.example.kongalong.day27_home_work.model.ClassifyAdvBeans;
import com.example.kongalong.day27_home_work.model.ClassifyBeans;

/**
 * Created by kongalong on 2016/11/17.
 */

public interface ClassifyListViewView extends MvpView {

    void refleshData(ClassifyBeans classifyBeans,ClassifyAdvBeans classifyAdvBeans);
}
