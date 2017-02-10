package com.example.kongalong.ximalaya_mvp.model;

import java.util.List;

/**
 * Created by kongalong on 2016/11/17.
 */

public class ClassifyAdvBeans implements BaseClassifyBeans{


    /**
     * ret : 0
     * responseId : 63004620937
     * data : [{"shareData":null,"isShareFlag":false,"thirdStatUrl":"http://g.cn.miaozhen.com/x/k=2033089&amp;p=73uZZ&amp;dx=__IPDX__&amp;rt=2&amp;ns={IP}&amp;ni=__IESID__&amp;v=__LOC__&amp;xa=__ADPLATFORM__&amp;o=","thirdShowStatUrls":null,"thirdClickStatUrls":null,"link":"","cover":"http://fdfs.xmcdn.com/group21/M08/46/BE/wKgJKFgsFdqR2ERTAAFiCVIDE10741.jpg","showstyle":1,"name":"","description":"","scheme":"","linkType":1,"displayType":1,"clickType":2,"openlinkType":0,"loadingShowTime":3000,"apkUrl":null,"adtype":0,"auto":false,"position":0,"adid":16251},{"shareData":null,"isShareFlag":false,"thirdStatUrl":"","thirdShowStatUrls":null,"thirdClickStatUrls":null,"link":"http://ad.ximalaya.com/adrecord?sdn=H4sIAAAAAAAAAKtWykhNTEktUrLKK83J0VFKzs_PzkyF8QoSixJzU0tSi4qVrKqVElM8S1JzPVOUrJQMTS1NzZVqawFBlXq8PwAAAA&amp;ad=15957&amp;jt2=aHR0cDovL2dhbWUueGltYWxheWEuY29tL2dhbWVzLW9wZXJhdGlvbi92MS9nYW1lcy9saXN0P2x5PWJmeWJhbm5lciZkb3Q9MQ&amp;jt=http%3A%2F%2Fgame.ximalaya.com%2Fgames-operation%2Fv1%2Fgames%2Flist%3Fly%3Dbfybanner%26dot%3D1","cover":"http://fdfs.xmcdn.com/group24/M08/1D/6E/wKgJMFgbUlrA5uQpAADodu29A38521.jpg","showstyle":1,"name":"","description":"","scheme":"","linkType":1,"displayType":1,"clickType":1,"openlinkType":0,"loadingShowTime":3000,"apkUrl":null,"adtype":0,"auto":false,"position":0,"adid":15957},{"shareData":null,"isShareFlag":false,"thirdStatUrl":"","thirdShowStatUrls":null,"thirdClickStatUrls":null,"link":"http://ad.ximalaya.com/adrecord?sdn=H4sIAAAAAAAAAKtWykhNTEktUrLKK83J0VFKzs_PzkyF8QoSixJzU0tSi4qVrKqVElM8S1JzPVOUrJQMTUzMTZVqawHAFlp2PwAAAA&amp;ad=14475&amp;jt2=aHR0cHM6Ly9rZHQuaW0va0ppUXBy&amp;jt=https%3A%2F%2Fkdt.im%2FkJiQpr","cover":"http://fdfs.xmcdn.com/group20/M05/70/72/wKgJJ1f8_k6CfvZjAACk36TU7BI165.jpg","showstyle":1,"name":"","description":"","scheme":"","linkType":1,"displayType":1,"clickType":1,"openlinkType":0,"loadingShowTime":3000,"apkUrl":null,"adtype":0,"auto":false,"position":0,"adid":14475},{"shareData":null,"isShareFlag":false,"thirdStatUrl":"http://g.cn.miaozhen.com/x/k=2006137&amp;p=6tAql&amp;dx=0&amp;rt=2&amp;ns={IP}&amp;ni=__IESID__&amp;v=__LOC__&amp;o=","thirdShowStatUrls":null,"thirdClickStatUrls":null,"link":"http://ad.ximalaya.com/adrecord?sdn=H4sIAAAAAAAAAKtWykhNTEktUrLKK83J0VFKzs_PzkyF8QoSixJzU0tSi4qVrKqVElM8S1JzPVOUrJQMjYwNDJVqawEFWM01PwAAAA&amp;ad=12301&amp;jt2=aHR0cDovL2dhbWUueGltYWxheWEuY29tL2dhbWVzLW9wZXJhdGlvbi92MS9nYW1lcy9saXN0&amp;jt=http%3A%2F%2Fgame.ximalaya.com%2Fgames-operation%2Fv1%2Fgames%2Flist","cover":"http://fdfs.xmcdn.com/group12/M0B/1B/00/wKgDW1bf-v6BDngKAAFMv4MKgIA533.jpg","showstyle":1,"name":"","description":"","scheme":"","linkType":1,"displayType":1,"clickType":1,"openlinkType":0,"loadingShowTime":3000,"apkUrl":null,"adtype":0,"auto":false,"position":0,"adid":12301}]
     * adTypes : [0,0,0,0]
     */

    private int ret;
    private long responseId;
    /**
     * shareData : null
     * isShareFlag : false
     * thirdStatUrl : http://g.cn.miaozhen.com/x/k=2033089&amp;p=73uZZ&amp;dx=__IPDX__&amp;rt=2&amp;ns={IP}&amp;ni=__IESID__&amp;v=__LOC__&amp;xa=__ADPLATFORM__&amp;o=
     * thirdShowStatUrls : null
     * thirdClickStatUrls : null
     * link :
     * cover : http://fdfs.xmcdn.com/group21/M08/46/BE/wKgJKFgsFdqR2ERTAAFiCVIDE10741.jpg
     * showstyle : 1
     * name :
     * description :
     * scheme :
     * linkType : 1
     * displayType : 1
     * clickType : 2
     * openlinkType : 0
     * loadingShowTime : 3000
     * apkUrl : null
     * adtype : 0
     * auto : false
     * position : 0
     * adid : 16251
     */

    private List<DataBean> data;
    private List<Integer> adTypes;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public long getResponseId() {
        return responseId;
    }

    public void setResponseId(long responseId) {
        this.responseId = responseId;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<Integer> getAdTypes() {
        return adTypes;
    }

    public void setAdTypes(List<Integer> adTypes) {
        this.adTypes = adTypes;
    }

    public static class DataBean {
        private Object shareData;
        private boolean isShareFlag;
        private String thirdStatUrl;
        private Object thirdShowStatUrls;
        private Object thirdClickStatUrls;
        private String link;
        private String cover;
        private int showstyle;
        private String name;
        private String description;
        private String scheme;
        private int linkType;
        private int displayType;
        private int clickType;
        private int openlinkType;
        private int loadingShowTime;
        private Object apkUrl;
        private int adtype;
        private boolean auto;
        private int position;
        private int adid;

        public Object getShareData() {
            return shareData;
        }

        public void setShareData(Object shareData) {
            this.shareData = shareData;
        }

        public boolean isIsShareFlag() {
            return isShareFlag;
        }

        public void setIsShareFlag(boolean isShareFlag) {
            this.isShareFlag = isShareFlag;
        }

        public String getThirdStatUrl() {
            return thirdStatUrl;
        }

        public void setThirdStatUrl(String thirdStatUrl) {
            this.thirdStatUrl = thirdStatUrl;
        }

        public Object getThirdShowStatUrls() {
            return thirdShowStatUrls;
        }

        public void setThirdShowStatUrls(Object thirdShowStatUrls) {
            this.thirdShowStatUrls = thirdShowStatUrls;
        }

        public Object getThirdClickStatUrls() {
            return thirdClickStatUrls;
        }

        public void setThirdClickStatUrls(Object thirdClickStatUrls) {
            this.thirdClickStatUrls = thirdClickStatUrls;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getShowstyle() {
            return showstyle;
        }

        public void setShowstyle(int showstyle) {
            this.showstyle = showstyle;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public int getLinkType() {
            return linkType;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }

        public int getDisplayType() {
            return displayType;
        }

        public void setDisplayType(int displayType) {
            this.displayType = displayType;
        }

        public int getClickType() {
            return clickType;
        }

        public void setClickType(int clickType) {
            this.clickType = clickType;
        }

        public int getOpenlinkType() {
            return openlinkType;
        }

        public void setOpenlinkType(int openlinkType) {
            this.openlinkType = openlinkType;
        }

        public int getLoadingShowTime() {
            return loadingShowTime;
        }

        public void setLoadingShowTime(int loadingShowTime) {
            this.loadingShowTime = loadingShowTime;
        }

        public Object getApkUrl() {
            return apkUrl;
        }

        public void setApkUrl(Object apkUrl) {
            this.apkUrl = apkUrl;
        }

        public int getAdtype() {
            return adtype;
        }

        public void setAdtype(int adtype) {
            this.adtype = adtype;
        }

        public boolean isAuto() {
            return auto;
        }

        public void setAuto(boolean auto) {
            this.auto = auto;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getAdid() {
            return adid;
        }

        public void setAdid(int adid) {
            this.adid = adid;
        }
    }
}
