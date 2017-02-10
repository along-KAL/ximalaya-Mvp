package com.example.kongalong.ximalaya_mvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kongalong.ximalaya_mvp.MainActivity;
import com.example.kongalong.ximalaya_mvp.MyApp;
import com.example.kongalong.ximalaya_mvp.R;
import com.example.kongalong.ximalaya_mvp.SampleImageLoad.SampleImageLoad;
import com.example.kongalong.ximalaya_mvp.model.TopBeans;
import com.example.kongalong.ximalaya_mvp.utils.ImageLoadUtil;

import java.util.List;

/**
 * Created by kongalong on 2016/11/18.
 */
public class TopListAdapter extends BaseAdapter{


    private Context mContext;
    private List<TopBeans.DatasBean> mData;

    private List<TopBeans.DatasBean.ListBean> mRealData1;
    private List<TopBeans.DatasBean.ListBean> mRealData2;

    private SampleImageLoad mSampleImageLoad;



    public TopListAdapter(Context context, List<TopBeans.DatasBean> data){
        this.mContext = context;
        this.mData = data;
        mSampleImageLoad = ((MyApp)((MainActivity)context).getApplication()).getSampleImageLoad();


    }


    @Override
    public int getCount() {
        if(mData.size()==0){
            return 0;
        }else{
            this.mRealData1= mData.get(0).getList();
            this.mRealData2= mData.get(1).getList();
        }
        return mRealData1.size()+mRealData2.size();
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
        ViewHolder holder  = null;
        if(convertView==null){

            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.top_list_item,parent,false);

            holder.mGapView = convertView.findViewById(R.id.top_list_gap);
            holder.mMainTitle = (TextView) convertView.findViewById(R.id.top_main_title);
            holder.mTitle = (TextView) convertView.findViewById(R.id.top_title);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.top_iamge);
            holder.mTag1 = (TextView) convertView.findViewById(R.id.top_tag1);
            holder.mTag2 = (TextView) convertView.findViewById(R.id.top_tag2);

            convertView.setTag(holder);
        }else{

            holder = (ViewHolder) convertView.getTag();
        }
        boolean sign = false;
        int index = 0;
        TopBeans.DatasBean.ListBean listBean = null;
        if(position>mRealData1.size()-1){
             listBean = mRealData2.get(position - mRealData1.size());

            if(position - mRealData1.size()==0){
                sign = true;
                index++;
            }

        }else{

             listBean = mRealData1.get(position);
            if(position==0){sign = true;}
        }

        if(sign){
            holder.mGapView.setVisibility(View.VISIBLE);
            holder.mMainTitle.setVisibility(View.VISIBLE);
            holder.mMainTitle.setText(mData.get(index).getTitle());
        }else{
            holder.mGapView.setVisibility(View.GONE);
            holder.mMainTitle.setVisibility(View.GONE);
        }

        holder.mTitle.setText(listBean.getTitle());
        holder.mTag1.setText(listBean.getFirstKResults().get(0).getTitle());
        holder.mTag2.setText(listBean.getFirstKResults().get(1).getTitle());
        ImageLoadUtil.showImage(mSampleImageLoad,listBean.getCoverPath(),holder.mImageView);


        return convertView;
    }

    private static class ViewHolder{

        private View mGapView;
        private TextView mMainTitle;

        private ImageView mImageView;
        private TextView mTitle;
        private TextView mTag1;
        private TextView mTag2;

    }
}
