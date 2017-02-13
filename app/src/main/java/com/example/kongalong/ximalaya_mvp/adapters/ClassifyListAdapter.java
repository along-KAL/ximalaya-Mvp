package com.example.kongalong.ximalaya_mvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kongalong.ximalaya_mvp.MainActivity;
import com.example.kongalong.ximalaya_mvp.MyApp;
import com.example.kongalong.ximalaya_mvp.R;
import com.example.kongalong.ximalaya_mvp.imageLoad.SampleImageLoad;
import com.example.kongalong.ximalaya_mvp.model.ClassifyBeans;
import com.example.kongalong.ximalaya_mvp.utils.ImageLoadUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by kongalong on 2016/11/17.
 */
public class ClassifyListAdapter extends BaseAdapter{

    private Context mContext;
    private List<Map<Integer,ClassifyBeans.ListBean>> mData;

    private SampleImageLoad mSampleImageLoad;

    public ClassifyListAdapter(Context context, List<Map<Integer,ClassifyBeans.ListBean>> data){

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
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.classify_list_item,parent,false);

            holder.mTextViewL1 = (TextView) convertView.findViewById(R.id.classify_text_L_1);
            holder.mTextViewR1 = (TextView) convertView.findViewById(R.id.classify_text_R_1);
            holder.mTextViewL2 = (TextView) convertView.findViewById(R.id.classify_text_L_2);
            holder.mTextViewR2 = (TextView) convertView.findViewById(R.id.classify_text_R_2);
            holder.mTextViewL3 = (TextView) convertView.findViewById(R.id.classify_text_L_3);
            holder.mTextViewR3 = (TextView) convertView.findViewById(R.id.classify_text_R_3);


            holder.mImageViewL1 = (ImageView) convertView.findViewById(R.id.classify_image_L_1);
            holder.mImageViewR1 = (ImageView) convertView.findViewById(R.id.classify_image_R_1);
            holder.mImageViewL2 = (ImageView) convertView.findViewById(R.id.classify_image_L_2);
            holder.mImageViewR2 = (ImageView) convertView.findViewById(R.id.classify_image_R_2);
            holder.mImageViewL3 = (ImageView) convertView.findViewById(R.id.classify_image_L_3);
            holder.mImageViewR3 = (ImageView) convertView.findViewById(R.id.classify_image_R_3);

            holder.mLinearLayoutL1 = (LinearLayout) convertView.findViewById(R.id.classify_layoutL1);
            holder.mLinearLayoutR1 = (LinearLayout) convertView.findViewById(R.id.classify_layoutR1);
            holder.mLinearLayoutL2 = (LinearLayout) convertView.findViewById(R.id.classify_layoutL2);
            holder.mLinearLayoutR2 = (LinearLayout) convertView.findViewById(R.id.classify_layoutR2);
            holder.mLinearLayoutL3 = (LinearLayout) convertView.findViewById(R.id.classify_layoutL3);
            holder.mLinearLayoutR3 = (LinearLayout) convertView.findViewById(R.id.classify_layoutR3);

            convertView.setTag(holder);
        }else{

            holder = (ViewHolder) convertView.getTag();

        }

        Map<Integer, ClassifyBeans.ListBean> integerListBeanMap = mData.get(position);



        if(integerListBeanMap.get(0)==null){
            holder.mLinearLayoutL1.setVisibility(View.GONE);
            holder.mLinearLayoutR1.setVisibility(View.GONE);
            holder.mLinearLayoutL2.setVisibility(View.GONE);
            holder.mLinearLayoutR2.setVisibility(View.GONE);
            holder.mLinearLayoutL3.setVisibility(View.GONE);
            holder.mLinearLayoutR3.setVisibility(View.GONE);
        }else if(integerListBeanMap.get(1)==null){
            holder.mTextViewL1.setText(integerListBeanMap.get(0).getTitle());
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(0).getCoverPath(),holder.mImageViewL1);
            holder.mLinearLayoutR1.setVisibility(View.GONE);
            holder.mLinearLayoutL2.setVisibility(View.GONE);
            holder.mLinearLayoutR1.setVisibility(View.GONE);
            holder.mLinearLayoutL3.setVisibility(View.GONE);
            holder.mLinearLayoutR3.setVisibility(View.GONE);
        }else if(integerListBeanMap.get(2)==null){
            holder.mTextViewL1.setText(integerListBeanMap.get(0).getTitle());
            holder.mTextViewR1.setText(integerListBeanMap.get(1).getTitle());
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(0).getCoverPath(),holder.mImageViewL1);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(1).getCoverPath(),holder.mImageViewR1);
            holder.mLinearLayoutL2.setVisibility(View.GONE);
            holder.mLinearLayoutR2.setVisibility(View.GONE);
            holder.mLinearLayoutL3.setVisibility(View.GONE);
            holder.mLinearLayoutR3.setVisibility(View.GONE);
        }else if(integerListBeanMap.get(3)==null){
            holder.mTextViewL1.setText(integerListBeanMap.get(0).getTitle());
            holder.mTextViewR1.setText(integerListBeanMap.get(1).getTitle());
            holder.mTextViewL2.setText(integerListBeanMap.get(2).getTitle());
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(0).getCoverPath(),holder.mImageViewL1);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(1).getCoverPath(),holder.mImageViewR1);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(2).getCoverPath(),holder.mImageViewL2);
            holder.mLinearLayoutR2.setVisibility(View.GONE);
            holder.mLinearLayoutL3.setVisibility(View.GONE);
            holder.mLinearLayoutR3.setVisibility(View.GONE);
        }else if(integerListBeanMap.get(4)==null){
            holder.mTextViewL1.setText(integerListBeanMap.get(0).getTitle());
            holder.mTextViewR1.setText(integerListBeanMap.get(1).getTitle());
            holder.mTextViewL2.setText(integerListBeanMap.get(2).getTitle());
            holder.mTextViewR2.setText(integerListBeanMap.get(3).getTitle());
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(0).getCoverPath(),holder.mImageViewL1);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(1).getCoverPath(),holder.mImageViewR1);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(2).getCoverPath(),holder.mImageViewL2);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(3).getCoverPath(),holder.mImageViewR2);
            holder.mLinearLayoutL3.setVisibility(View.GONE);
            holder.mLinearLayoutR3.setVisibility(View.GONE);
        }else if(integerListBeanMap.get(5)==null){
            holder.mTextViewL1.setText(integerListBeanMap.get(0).getTitle());
            holder.mTextViewR1.setText(integerListBeanMap.get(1).getTitle());
            holder.mTextViewL2.setText(integerListBeanMap.get(2).getTitle());
            holder.mTextViewR2.setText(integerListBeanMap.get(3).getTitle());
            holder.mTextViewL3.setText(integerListBeanMap.get(4).getTitle());
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(0).getCoverPath(),holder.mImageViewL1);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(1).getCoverPath(),holder.mImageViewR1);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(2).getCoverPath(),holder.mImageViewL2);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(3).getCoverPath(),holder.mImageViewR2);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(4).getCoverPath(),holder.mImageViewL3);
            holder.mLinearLayoutR3.setVisibility(View.GONE);
        }else{
            holder.mTextViewL1.setText(integerListBeanMap.get(0).getTitle());
            holder.mTextViewR1.setText(integerListBeanMap.get(1).getTitle());
            holder.mTextViewL2.setText(integerListBeanMap.get(2).getTitle());
            holder.mTextViewR2.setText(integerListBeanMap.get(3).getTitle());
            holder.mTextViewL3.setText(integerListBeanMap.get(4).getTitle());
            holder.mTextViewR3.setText(integerListBeanMap.get(5).getTitle());
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(0).getCoverPath(),holder.mImageViewL1);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(1).getCoverPath(),holder.mImageViewR1);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(2).getCoverPath(),holder.mImageViewL2);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(3).getCoverPath(),holder.mImageViewR2);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(4).getCoverPath(),holder.mImageViewL3);
            ImageLoadUtil.showImage(mSampleImageLoad,integerListBeanMap.get(5).getCoverPath(),holder.mImageViewR3);
        }


        return convertView;
    }


    private static class ViewHolder{

        private TextView mTextViewL1;
        private TextView mTextViewR1;

        private TextView mTextViewL2;
        private TextView mTextViewR2;

        private TextView mTextViewL3;
        private TextView mTextViewR3;


        private ImageView mImageViewL1;
        private ImageView mImageViewR1;

        private ImageView mImageViewL2;
        private ImageView mImageViewR2;

        private ImageView mImageViewL3;
        private ImageView mImageViewR3;

        private LinearLayout mLinearLayoutL1;
        private LinearLayout mLinearLayoutR1;

        private LinearLayout mLinearLayoutL2;
        private LinearLayout mLinearLayoutR2;

        private LinearLayout mLinearLayoutL3;
        private LinearLayout mLinearLayoutR3;


    }

}
