package com.example.kongalong.day27_home_work.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kongalong.day27_home_work.Constants.Constans;
import com.example.kongalong.day27_home_work.MainActivity;
import com.example.kongalong.day27_home_work.MyApp;
import com.example.kongalong.day27_home_work.R;
import com.example.kongalong.day27_home_work.SampleImageLoad.SampleImageLoad;
import com.example.kongalong.day27_home_work.model.BroadcastBeans;
import com.example.kongalong.day27_home_work.utils.ImageLoadUtil;

import java.util.List;

/**
 * Created by kongalong on 2016/11/18.
 */
public class BroadcastListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Object> mData;
    private SampleImageLoad mSampleImageLoad;


    public BroadcastListAdapter(Context context, List<Object> data) {
        mContext = context;
        mData = data;
        mSampleImageLoad = ((MyApp)((MainActivity)context).getApplication()).getSampleImageLoad();

    }

    @Override
    public int getCount() {
        return mData!=null?mData.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        switch(position){
            case 0:
                return Constans.BROADCAST_STATION;
            case 1:
                return Constans.BROADCAST_RECOMMEND_STATION;
            case 2:
                return Constans.BROADCAST_TOP_STATION;
            default:
                return -1;
        }
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        StationViewHolder stationViewHolder = null;
        RecommendStationViewHolder recommendStationViewHolder = null;
        TopStationViewHolder topStationViewHolder = null;
        switch(getItemViewType(position)){

            case Constans.BROADCAST_STATION:

                if(convertView==null){

                    stationViewHolder = new StationViewHolder();
                    convertView = LayoutInflater.from(mContext).inflate
                            (R.layout.broadcast_station_item,parent,false);

                    convertView.setTag(stationViewHolder);
                }else{
                    stationViewHolder = (StationViewHolder) convertView.getTag();
                }


                break;



            case Constans.BROADCAST_RECOMMEND_STATION:

                if(convertView==null){
                    recommendStationViewHolder = new RecommendStationViewHolder();
                    convertView = LayoutInflater.from(mContext).inflate
                            (R.layout.broadcast_recommendstation_item,parent,false);


                    recommendStationViewHolder.mRecommendStationImageVew1 =
                            (ImageView) convertView.findViewById(R.id.broadcast_recommend_image1);
                    recommendStationViewHolder.mRecommendStationImageVew2 =
                            (ImageView) convertView.findViewById(R.id.broadcast_recommend_image2);
                    recommendStationViewHolder.mRecommendStationImageVew3 =
                            (ImageView) convertView.findViewById(R.id.broadcast_recommend_image3);


                    recommendStationViewHolder.mRecommendStationTitle1 =
                            (TextView) convertView.findViewById(R.id.broadcast_recommend_text1);
                    recommendStationViewHolder.mRecommendStationTitle2 =
                            (TextView) convertView.findViewById(R.id.broadcast_recommend_text2);
                    recommendStationViewHolder.mRecommendStationTitle3 =
                            (TextView) convertView.findViewById(R.id.broadcast_recommend_text3);



                    convertView.setTag(recommendStationViewHolder);
                }else{
                    recommendStationViewHolder = (RecommendStationViewHolder) convertView.getTag();
                }
                //获取数据
                List<BroadcastBeans.ResultBean.RecommandRadioListBean>
                        recommandRadioListBean = (List<BroadcastBeans.ResultBean.RecommandRadioListBean>) mData.get(position);

                recommendStationViewHolder.mRecommendStationTitle1.setText
                        (recommandRadioListBean.get(0).getRname());
                recommendStationViewHolder.mRecommendStationTitle2.setText
                        (recommandRadioListBean.get(1).getRname());
                recommendStationViewHolder.mRecommendStationTitle3.setText
                        (recommandRadioListBean.get(2).getRname());

                ImageLoadUtil.showImage(mSampleImageLoad
                        ,recommandRadioListBean.get(0).getPicPath()
                        ,recommendStationViewHolder.mRecommendStationImageVew1);
                ImageLoadUtil.showImage(mSampleImageLoad
                        ,recommandRadioListBean.get(1).getPicPath()
                        ,recommendStationViewHolder.mRecommendStationImageVew2);
                ImageLoadUtil.showImage(mSampleImageLoad
                        ,recommandRadioListBean.get(2).getPicPath()
                        ,recommendStationViewHolder.mRecommendStationImageVew3);
                break;



            case Constans.BROADCAST_TOP_STATION:

                    if(convertView==null){
                        topStationViewHolder = new TopStationViewHolder();
                        convertView = LayoutInflater.from(mContext).inflate
                                (R.layout.broadcast_topstation_item,parent,false);

                        topStationViewHolder.mTopStationImage1 = (ImageView) convertView.findViewById(R.id.broadcast_topstation_iamge1);
                        topStationViewHolder.mTopStationImage2 = (ImageView) convertView.findViewById(R.id.broadcast_topstation_iamge2);
                        topStationViewHolder.mTopStationImage3 = (ImageView) convertView.findViewById(R.id.broadcast_topstation_iamge3);

                        topStationViewHolder.mTopStationTitle1 = (TextView) convertView.findViewById(R.id.broadcast_topstation_title1);
                        topStationViewHolder.mTopStationTitle2 = (TextView) convertView.findViewById(R.id.broadcast_topstation_title2);
                        topStationViewHolder.mTopStationTitle3 = (TextView) convertView.findViewById(R.id.broadcast_topstation_title3);

                        topStationViewHolder.mTopStationTag1 = (TextView) convertView.findViewById(R.id.broadcast_topstation_tag1);
                        topStationViewHolder.mTopStationTag2 = (TextView) convertView.findViewById(R.id.broadcast_topstation_tag2);
                        topStationViewHolder.mTopStationTag3 = (TextView) convertView.findViewById(R.id.broadcast_topstation_tag3);

                        topStationViewHolder.mTopStationCount1 = (TextView) convertView.findViewById(R.id.broadcast_topstation_count1);
                        topStationViewHolder.mTopStationCount2 = (TextView) convertView.findViewById(R.id.broadcast_topstation_count2);
                        topStationViewHolder.mTopStationCount3 = (TextView) convertView.findViewById(R.id.broadcast_topstation_count3);



                        convertView.setTag(topStationViewHolder);
                    }else{
                        topStationViewHolder = (TopStationViewHolder) convertView.getTag();
                    }


                //获取数据
                List<BroadcastBeans.ResultBean.TopRadioListBean>
                        topRadioListBean = (List<BroadcastBeans.ResultBean.TopRadioListBean>) mData.get(position);

                ImageLoadUtil.showImage(mSampleImageLoad
                        ,topRadioListBean.get(0).getRadioCoverLarge()
                        ,topStationViewHolder.mTopStationImage1);
                ImageLoadUtil.showImage(mSampleImageLoad
                        ,topRadioListBean.get(1).getRadioCoverLarge()
                        ,topStationViewHolder.mTopStationImage2);
                ImageLoadUtil.showImage(mSampleImageLoad
                        ,topRadioListBean.get(2).getRadioCoverLarge()
                        ,topStationViewHolder.mTopStationImage3);

                topStationViewHolder.mTopStationTitle1.setText
                        (topRadioListBean.get(0).getRname());
                topStationViewHolder.mTopStationTitle2.setText
                        (topRadioListBean.get(1).getRname());
                topStationViewHolder.mTopStationTitle3.setText
                        (topRadioListBean.get(2).getRname());

                topStationViewHolder.mTopStationTag1.setText
                        ("正在直播："+topRadioListBean.get(0).getProgramName());
                topStationViewHolder.mTopStationTag2.setText
                        ("正在直播："+topRadioListBean.get(1).getProgramName());
                topStationViewHolder.mTopStationTag3.setText
                        ("正在直播："+topRadioListBean.get(2).getProgramName());

                topStationViewHolder.mTopStationCount1.setText
                        (topRadioListBean.get(0).getRadioPlayCount()/10000+"万人");
                topStationViewHolder.mTopStationCount2.setText
                        (topRadioListBean.get(1).getRadioPlayCount()/10000+"万人");
                topStationViewHolder.mTopStationCount3.setText
                        (topRadioListBean.get(2).getRadioPlayCount()/10000+"万人");

                break;
        }


        return convertView;
    }



    private static class StationViewHolder{




    }

    private static class RecommendStationViewHolder{

        private ImageView mRecommendStationImageVew1;
        private ImageView mRecommendStationImageVew2;
        private ImageView mRecommendStationImageVew3;

        private TextView mRecommendStationTitle1;
        private TextView mRecommendStationTitle2;
        private TextView mRecommendStationTitle3;


    }

    private static class TopStationViewHolder{

        private ImageView mTopStationImage1;
        private ImageView mTopStationImage2;
        private ImageView mTopStationImage3;

        private TextView mTopStationTitle1;
        private TextView mTopStationTitle2;
        private TextView mTopStationTitle3;

        private TextView mTopStationTag1;
        private TextView mTopStationTag2;
        private TextView mTopStationTag3;

        private TextView mTopStationCount1;
        private TextView mTopStationCount2;
        private TextView mTopStationCount3;

    }
}
