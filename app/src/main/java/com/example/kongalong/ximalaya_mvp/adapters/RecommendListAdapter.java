package com.example.kongalong.ximalaya_mvp.adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kongalong.ximalaya_mvp.constants.Constans;
import com.example.kongalong.ximalaya_mvp.MainActivity;
import com.example.kongalong.ximalaya_mvp.MyApp;
import com.example.kongalong.ximalaya_mvp.R;
import com.example.kongalong.ximalaya_mvp.imageLoad.SampleImageLoad;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans1;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans2;
import com.example.kongalong.ximalaya_mvp.utils.ImageLoadUtil;

import java.util.List;

/**
 * Created by kongalong on 2016/11/10.
 */
public class RecommendListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Object> mListData1;

    private SampleImageLoad mSampleImageLoad;


    private boolean mIsScroll;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public RecommendListAdapter(Context context, List<Object> listData1) {
        this.mContext = context;
        this.mListData1 = listData1;
        mSampleImageLoad = ((MyApp)((MainActivity)context).getApplication()).getSampleImageLoad();

        mIsScroll = false;
    }

    @Override
    public int getCount() {
        return mListData1!=null?mListData1.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mListData1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {

        switch(position){
            case 0:
                return Constans.GUESS_POSITION;
            case 1:
                return Constans.EDIT_RECOMMEND;
            case 2:
                return Constans.QUALITY_POSITION;
            default:
                return Constans.NORMAL_POSITION;
        }
    }


    public void setIsScroll(boolean isScroll){
        mIsScroll = isScroll;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 guessHolder = null;
        ViewHolder2 qualityHolder = null;
        ViewHolder3 normalHolder = null;


            int type = getItemViewType(position);
            switch(type){
                case Constans.GUESS_POSITION:

                    List<RecommendBeans2.GuessBean.ListBean> guessList=
                            (List<RecommendBeans2.GuessBean.ListBean>)
                                    mListData1.get(position);
                    if(guessList.size()==0){break;}

                    if(convertView==null){

                        guessHolder = new ViewHolder1();
                        convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_list_item_guess,parent,false);

                        guessHolder.mMore1 = (TextView) convertView.findViewById(R.id.guess_title1);
                        guessHolder.mTitle1 = (TextView) convertView.findViewById(R.id.guess_more1);

                        guessHolder.mText1 = (TextView) convertView.findViewById(R.id.guess_text1);
                        guessHolder.mImage1 = (ImageView) convertView.findViewById(R.id.guess_image1);
                        guessHolder.mclassText1 = (TextView) convertView.findViewById(R.id.guess_text_class1);

                        guessHolder.mText2 = (TextView) convertView.findViewById(R.id.guess_text2);
                        guessHolder.mImage2 = (ImageView) convertView.findViewById(R.id.guess_image2);
                        guessHolder.mclassText2 = (TextView) convertView.findViewById(R.id.guess_text_class2);

                        guessHolder.mText3 = (TextView) convertView.findViewById(R.id.guess_text3);
                        guessHolder.mImage3 = (ImageView) convertView.findViewById(R.id.guess_image3);
                        guessHolder.mclassText3 = (TextView) convertView.findViewById(R.id.guess_text_class3);




                        guessHolder.mText4 = (TextView) convertView.findViewById(R.id.guess_text4);
                        guessHolder.mImage4 = (ImageView) convertView.findViewById(R.id.guess_image4);
                        guessHolder.mclassText4 = (TextView) convertView.findViewById(R.id.guess_text_class4);

                        guessHolder.mText5 = (TextView) convertView.findViewById(R.id.guess_text5);
                        guessHolder.mImage5 = (ImageView) convertView.findViewById(R.id.guess_image5);
                        guessHolder.mclassText5 = (TextView) convertView.findViewById(R.id.guess_text_class5);

                        guessHolder.mText6 = (TextView) convertView.findViewById(R.id.guess_text6);
                        guessHolder.mImage6 = (ImageView) convertView.findViewById(R.id.guess_image6);
                        guessHolder.mclassText6 = (TextView) convertView.findViewById(R.id.guess_text_class6);

                        convertView.setTag(guessHolder);

                    }else {
                        guessHolder = (ViewHolder1) convertView.getTag();
                    }
                    // TODO: 2016/11/11 set guess data


                    //设置默认图片
                    guessHolder.mImage1.setImageResource(R.mipmap.image_default);
                    guessHolder.mImage2.setImageResource(R.mipmap.image_default);
                    guessHolder.mImage3.setImageResource(R.mipmap.image_default);
                    guessHolder.mImage4.setImageResource(R.mipmap.image_default);
                    guessHolder.mImage5.setImageResource(R.mipmap.image_default);
                    guessHolder.mImage6.setImageResource(R.mipmap.image_default);


                    guessHolder.mText1.setText(guessList.get(0).getTitle());
                    guessHolder.mclassText1.setText(guessList.get(0).getTags()
                            !=null?guessList.get(0).getTags():"");

                    guessHolder.mText2.setText(guessList.get(1).getTitle());
                    guessHolder.mclassText2.setText(guessList.get(1).getTags()
                            !=null?guessList.get(1).getTags():"");

                    guessHolder.mText3.setText(guessList.get(2).getTitle());
                    guessHolder.mclassText3.setText(guessList.get(2).getTags()
                            !=null?guessList.get(2).getTags():"");

                    guessHolder.mText4.setText(guessList.get(3).getTitle());
                    guessHolder.mclassText4.setText(guessList.get(3).getTags()
                            !=null?guessList.get(3).getTags():"");

                    guessHolder.mText5.setText(guessList.get(4).getTitle());
                    guessHolder.mclassText5.setText(guessList.get(4).getTags()
                            !=null?guessList.get(1).getTags():"");

                    guessHolder.mText6.setText(guessList.get(5).getTitle());
                    guessHolder.mclassText6.setText(guessList.get(5).getTags()
                            !=null?guessList.get(5).getTags():"");

                    if(!mIsScroll){
                        ImageLoadUtil.showImage(mSampleImageLoad,guessList.get(0).getCoverLarge(),guessHolder.mImage1);
                        ImageLoadUtil.showImage(mSampleImageLoad,guessList.get(1).getCoverLarge(),guessHolder.mImage2);
                        ImageLoadUtil.showImage(mSampleImageLoad,guessList.get(2).getCoverLarge(),guessHolder.mImage3);
                        ImageLoadUtil.showImage(mSampleImageLoad,guessList.get(3).getCoverLarge(),guessHolder.mImage4);
                        ImageLoadUtil.showImage(mSampleImageLoad,guessList.get(4).getCoverLarge(),guessHolder.mImage5);
                        ImageLoadUtil.showImage(mSampleImageLoad,guessList.get(5).getCoverLarge(),guessHolder.mImage6);
                    }

                    break;
                case Constans.EDIT_RECOMMEND:

                    List<RecommendBeans1.EditorRecommendAlbumsBean.ListBean> editRecommendList=
                            ( List<RecommendBeans1.EditorRecommendAlbumsBean.ListBean>)
                                    mListData1.get(position);

                    if(editRecommendList.size()==0){break;}

                    if(convertView==null){
                        normalHolder = new ViewHolder3();
                        convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_list_item_normal,parent,false);

                        normalHolder.mMore1 = (TextView) convertView.findViewById(R.id.normal_more1);
                        normalHolder.mTitle1 = (TextView) convertView.findViewById(R.id.normal_title1);

                        normalHolder.mText1 = (TextView) convertView.findViewById(R.id.normal_text1);
                        normalHolder.mImage1 = (ImageView) convertView.findViewById(R.id.normal_image1);
                        normalHolder.mShortText1 = (TextView) convertView.findViewById(R.id.normal_text2);

                        normalHolder.mText2 = (TextView) convertView.findViewById(R.id.normal_text11);
                        normalHolder.mImage2 = (ImageView) convertView.findViewById(R.id.normal_image11);
                        normalHolder.mShortText2 = (TextView) convertView.findViewById(R.id.normal_text22);

                        normalHolder.mText3 = (TextView) convertView.findViewById(R.id.normal_text111);
                        normalHolder.mImage3 = (ImageView) convertView.findViewById(R.id.normal_image111);
                        normalHolder.mShortText3 = (TextView) convertView.findViewById(R.id.normal_text222);

                        convertView.setTag(normalHolder);

                    }else {
                        normalHolder = (ViewHolder3) convertView.getTag();
                    }
                    // TODO: 2016/11/11 set normal data


                    //设置默认图片
                    normalHolder.mImage1.setImageResource(R.mipmap.image_default);
                    normalHolder.mImage2.setImageResource(R.mipmap.image_default);
                    normalHolder.mImage3.setImageResource(R.mipmap.image_default);


                    normalHolder.mTitle1.setText("小编推荐");

                    normalHolder.mText1.setText(editRecommendList.get(0)
                            .getTrackTitle());
                    normalHolder.mShortText1.setText(editRecommendList.get(0).getTitle());


                    normalHolder.mText2.setText(editRecommendList.get(1)
                            .getTrackTitle());
                    normalHolder.mShortText2.setText(editRecommendList.get(1).getTitle());


                    normalHolder.mText3.setText(editRecommendList.get(2)
                            .getTrackTitle());
                    normalHolder.mShortText3.setText(editRecommendList.get(2).getTitle());


                    if(!mIsScroll){
                        ImageLoadUtil.showImage(mSampleImageLoad,editRecommendList.get(0).getCoverLarge(),
                                normalHolder.mImage1);
                        ImageLoadUtil.showImage(mSampleImageLoad,editRecommendList.get(1).getCoverLarge(),
                                normalHolder.mImage2);
                        ImageLoadUtil.showImage(mSampleImageLoad,editRecommendList.get(2).getCoverLarge(),
                                normalHolder.mImage3);
                    }

                    break;
             case Constans.QUALITY_POSITION:

                 List<RecommendBeans1.SpecialColumnBean.ListBean> speciaList =
                         ( List<RecommendBeans1.SpecialColumnBean.ListBean>)
                                 mListData1.get(position);
                if(speciaList.size()==0){break;}

                 if(convertView==null){
                        qualityHolder = new ViewHolder2();
                        convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_list_item_quality,parent,false);

                        qualityHolder.mMore1 = (TextView) convertView.findViewById(R.id.quality_more1);
                        qualityHolder.mTitle1 = (TextView) convertView.findViewById(R.id.quality_title1);

                        qualityHolder.mImage1 = (ImageView) convertView.findViewById(R.id.quality_image1);
                        qualityHolder.mText1 = (TextView) convertView.findViewById(R.id.quality_text_title1);
                        qualityHolder.mText2 = (TextView) convertView.findViewById(R.id.quality_text_title2);
                        qualityHolder.mText3 = (TextView) convertView.findViewById(R.id.quality_text_title3);

                        qualityHolder.mImage11 = (ImageView) convertView.findViewById(R.id.quality_image2);
                        qualityHolder.mText11 = (TextView) convertView.findViewById(R.id.quality_text_title11);
                        qualityHolder.mText22 = (TextView) convertView.findViewById(R.id.quality_text_title22);
                        qualityHolder.mText33 = (TextView) convertView.findViewById(R.id.quality_text_title33);


                        convertView.setTag(qualityHolder);

                    }else {
                        qualityHolder = (ViewHolder2) convertView.getTag();
                    }
                    // TODO: 2016/11/11 set quality data

                 //设置默认图片
                 qualityHolder.mImage1.setImageResource(R.mipmap.image_default);
                 qualityHolder.mImage11.setImageResource(R.mipmap.image_default);



                 qualityHolder.mText1.setText(speciaList.get(0).getTitle());
                 qualityHolder.mText2.setText(speciaList.get(0).getSubtitle());
                 qualityHolder.mText3.setText(speciaList.get(0).getFootnote());

                 if(speciaList.size()>1){
                     qualityHolder.mText11.setText(speciaList.get(1).getTitle());
                     qualityHolder.mText22.setText(speciaList.get(1).getSubtitle());
                     qualityHolder.mText33.setText(speciaList.get(1).getFootnote());

                 }

                 if(!mIsScroll){
                     ImageLoadUtil.showImage(mSampleImageLoad,speciaList.get(0).getCoverPath(),
                             qualityHolder.mImage1);

                     if(speciaList.size()>1){
                         ImageLoadUtil.showImage(mSampleImageLoad,speciaList.get(1).getCoverPath(),
                                 qualityHolder.mImage11);
                     }

                 }

                    break;
                case Constans.NORMAL_POSITION:


                    if(convertView==null){
                    normalHolder = new ViewHolder3();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_list_item_normal,parent,false);

                    normalHolder.mMore1 = (TextView) convertView.findViewById(R.id.normal_more1);
                    normalHolder.mTitle1 = (TextView) convertView.findViewById(R.id.normal_title1);

                    normalHolder.mText1 = (TextView) convertView.findViewById(R.id.normal_text1);
                    normalHolder.mImage1 = (ImageView) convertView.findViewById(R.id.normal_image1);
                    normalHolder.mShortText1 = (TextView) convertView.findViewById(R.id.normal_text2);

                    normalHolder.mText2 = (TextView) convertView.findViewById(R.id.normal_text11);
                    normalHolder.mImage2 = (ImageView) convertView.findViewById(R.id.normal_image11);
                    normalHolder.mShortText2 = (TextView) convertView.findViewById(R.id.normal_text22);

                    normalHolder.mText3 = (TextView) convertView.findViewById(R.id.normal_text111);
                    normalHolder.mImage3 = (ImageView) convertView.findViewById(R.id.normal_image111);
                    normalHolder.mShortText3 = (TextView) convertView.findViewById(R.id.normal_text222);

                    convertView.setTag(normalHolder);

                    }else {
                        normalHolder = (ViewHolder3) convertView.getTag();
                    }
                    // TODO: 2016/11/11 set normal data
                    //设置默认图片
                    normalHolder.mImage1.setImageResource(R.mipmap.image_default);
                    normalHolder.mImage2.setImageResource(R.mipmap.image_default);
                    normalHolder.mImage3.setImageResource(R.mipmap.image_default);



                    RecommendBeans2.HotRecommendsBean.ListBean normalList
                            = (RecommendBeans2.HotRecommendsBean.ListBean)
                            mListData1.get(position);

                    normalHolder.mTitle1.setText(normalList.getTitle());



                    normalHolder.mText1.setText(normalList.getList().get(0)
                            .getTrackTitle());
                    normalHolder.mShortText1.setText(normalList.getList().get(0).getTitle());


                    normalHolder.mText2.setText(normalList.getList().get(1)
                            .getTrackTitle());
                    normalHolder.mShortText2.setText(normalList.getList().get(1).getTitle());


                    normalHolder.mText3.setText(normalList.getList().get(2)
                            .getTrackTitle());
                    normalHolder.mShortText3.setText(normalList.getList().get(2).getTitle());


                    if(!mIsScroll){
                        ImageLoadUtil.showImage(mSampleImageLoad,normalList.getList().get(0).getCoverLarge(),
                                normalHolder.mImage1);
                        ImageLoadUtil.showImage(mSampleImageLoad,normalList.getList().get(1).getCoverLarge(),
                                normalHolder.mImage2);
                        ImageLoadUtil.showImage(mSampleImageLoad,normalList.getList().get(2).getCoverLarge(),
                                normalHolder.mImage3);
                    }

                    break;
                default:
                    break;
            }


        return convertView;
    }





    private static class ViewHolder1{

        private TextView mTitle1;
        private TextView mMore1;

        private ImageView mImage1;
        private TextView mText1;
        private TextView mclassText1;

        private ImageView mImage2;
        private TextView mText2;
        private TextView mclassText2;

        private ImageView mImage3;
        private TextView mText3;
        private TextView mclassText3;



        private ImageView mImage4;
        private TextView mText4;
        private TextView mclassText4;

        private ImageView mImage5;
        private TextView mText5;
        private TextView mclassText5;

        private ImageView mImage6;
        private TextView mText6;
        private TextView mclassText6;

    }

    private static class ViewHolder2{

        private TextView mTitle1;
        private TextView mMore1;

        private ImageView mImage1;
        private TextView mText1;
        private TextView mText2;
        private TextView mText3;

        private ImageView mImage11;
        private TextView mText11;
        private TextView mText22;
        private TextView mText33;

    }

    private static class ViewHolder3{

        private TextView mTitle1;
        private TextView mMore1;

        private ImageView mImage1;
        private TextView mText1;
        private TextView mShortText1;

        private ImageView mImage2;
        private TextView mText2;
        private TextView mShortText2;

        private ImageView mImage3;
        private TextView mText3;
        private TextView mShortText3;

    }

}
