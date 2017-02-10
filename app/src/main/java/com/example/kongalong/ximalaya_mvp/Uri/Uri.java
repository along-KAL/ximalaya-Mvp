package com.example.kongalong.ximalaya_mvp.Uri;

/**
 * Created by kongalong on 2016/11/10.
 */

public class Uri {

    //发现界面栏目条
    public static final String  discoverTab =
            "http://mobile.ximalaya.com/mobile/discovery/v1/tabs?device=android";


    /**
     * 推荐  Uri
     *
     */
    public static final String DISCOVERRECOMMEND_URL1 =
"http://mobile.ximalaya.com/mobile/discovery/v3/recommends?channel=and-a1&device" +
        "=android&includeActivity=true&includeSpecial=true&scale=2&version=4.3.98";


    public static final String DISCOVERRECOMMEND_URL2 = "http://mobile.ximalaya." +
            "com/mobile/discovery/v1/recommend/hotAndGuess?device=android";

    //底部广告
    public static final String DISCOVERRECOMMEND_URL3 = "http://adse.ximalaya.com/" +
            "ting?device=android&name=find_banner&network=wifi&operator=" +
            "0&version=4.3.98";





    /**
     * 分类  Uri
     *
     */
    public static final String CLASSIFY_URL = "http://mobile.ximalaya.com/mobile/discovery/v1/categories?channel=and-a1&device=android&picVersion=13&scale=2";

    public static final String CLASSIFY_ADV_URL = "http://adse.ximalaya.com/ting?device=android&name=cata_index_banner&network=wifi&operator=0&version=4.3.98";



    /**
     * 榜单  Uri
     *
     */
    public static final String TOP_URL = "http://mobile.ximalaya.com/mobile/discovery/v2/rankingList/group?channel=and-a1&device=android&includeActivity=true&includeSpecial=true&scale=2&version=4.3.98";

    public static final String BROADCAST_URL = "http://live.ximalaya.com/live-web/v1/getHomePageRadiosList";



    /**
     * 主播  Uri
     *
     */
    public static final String ANCHOR_URL = "http://mobile.ximalaya.com/m/explore_user_index?device=android&page=";
}
