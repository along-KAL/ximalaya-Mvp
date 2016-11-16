package com.example.kongalong.day27_home_work.utils;

import com.example.kongalong.day27_home_work.model.RecommendBeans1;
import com.example.kongalong.day27_home_work.model.RecommendBeans2;
import com.example.kongalong.day27_home_work.model.RecommendBeans3;
import com.google.gson.Gson;

/**
 * Created by kongalong on 2016/11/10.
 */

public class JsonParseUtil {



    public static RecommendBeans1 parseJsonToRecommendBeans1(String json){

        Gson gson = new Gson();

        return gson.fromJson(json, RecommendBeans1.class);

    }

    public static RecommendBeans2 parseJsonToRecommendBeans2(String json){

        Gson gson = new Gson();

        return gson.fromJson(json, RecommendBeans2.class);

    }
    public static RecommendBeans3 parseJsonToRecommendBeans3(String json){

        Gson gson = new Gson();

        return gson.fromJson(json, RecommendBeans3.class);

    }





}
