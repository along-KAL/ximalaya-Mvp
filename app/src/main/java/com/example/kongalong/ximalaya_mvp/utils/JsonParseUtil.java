package com.example.kongalong.ximalaya_mvp.utils;

import com.example.kongalong.ximalaya_mvp.model.AnchorBeans;
import com.example.kongalong.ximalaya_mvp.model.BroadcastBeans;
import com.example.kongalong.ximalaya_mvp.model.ClassifyAdvBeans;
import com.example.kongalong.ximalaya_mvp.model.ClassifyBeans;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans1;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans2;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans3;
import com.example.kongalong.ximalaya_mvp.model.TopBeans;
import com.google.gson.Gson;

/**
 * Created by kongalong on 2016/11/10.
 */

public class JsonParseUtil {


    /**
     *
     * RecommendBeans
     *
     */

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











    /**
     *
     * ClassifyBeans
     *
     */

    public static ClassifyBeans parseJsonToClassifyBeans(String json){

        Gson gson = new Gson();

        return gson.fromJson(json, ClassifyBeans.class);

    }

    public static ClassifyAdvBeans parseJsonToClassifyAdvBeans(String json){

        Gson gson = new Gson();

        return gson.fromJson(json, ClassifyAdvBeans.class);

    }





    /**
     *
     * TopBeans
     *
     */
    public static TopBeans parseJsonToTopBeans(String json){

        Gson gson = new Gson();

        return gson.fromJson(json, TopBeans.class);

    }

    /**
     *
     * BroadcastBeans
     *
     */
    public static BroadcastBeans parseJsonToBroadcastBeans(String json) {

        Gson gson = new Gson();

        return gson.fromJson(json, BroadcastBeans.class);

    }

    /**
     *
     * AnchorBeans
     *
     */
    public static AnchorBeans parseJsonToAnchorBeans(String json) {

        Gson gson = new Gson();

        return gson.fromJson(json, AnchorBeans.class);

    }
}
