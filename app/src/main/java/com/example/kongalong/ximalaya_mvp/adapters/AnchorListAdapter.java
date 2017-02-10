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
import com.example.kongalong.ximalaya_mvp.model.AnchorBeans;
import com.example.kongalong.ximalaya_mvp.utils.ImageLoadUtil;

import java.util.List;

/**
 * Created by kongalong on 2016/11/18.
 */
public class AnchorListAdapter extends BaseAdapter{


    private Context mContext;
    private List<AnchorBeans.ListBean> mData;
    private SampleImageLoad mSampleImageLoad;


    public AnchorListAdapter(Context context, List<AnchorBeans.ListBean> data){
        this.mContext = context;
        this.mData = data;
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

        if(convertView==null){

            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.anchor_list_item,parent,false);


             holder.mAnchorMainTitle = (TextView) convertView
                     .findViewById(R.id.anchor_mian_title);

             holder.mAnchorImage1 = (ImageView) convertView
                     .findViewById(R.id.anchor_image1);
            holder.mAnchorImage2 = (ImageView) convertView
                    .findViewById(R.id.anchor_image2);
            holder.mAnchorImage3 = (ImageView) convertView
                    .findViewById(R.id.anchor_image3);


            holder.mAnchorTitle1 = (TextView) convertView
                    .findViewById(R.id.anchor_text1);
            holder.mAnchorTitle2 = (TextView) convertView
                    .findViewById(R.id.anchor_text2);
            holder.mAnchorTitle3 = (TextView) convertView
                    .findViewById(R.id.anchor_text3);



            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }



        //设置默认图片
        holder.mAnchorImage1.setImageResource(R.mipmap.image_default);
        holder.mAnchorImage2.setImageResource(R.mipmap.image_default);
        holder.mAnchorImage3.setImageResource(R.mipmap.image_default);


        AnchorBeans.ListBean listBean = mData.get(position);
        List<AnchorBeans.ListBean.ListBean1> list = listBean.getList();
        if (list == null||list.size()==0) {
            return convertView;
        }
        holder.mAnchorMainTitle.setText(listBean.getTitle());

        holder.mAnchorTitle1.setText(list.get(0).getNickname());
        holder.mAnchorTitle2.setText(list.get(1).getNickname());
        holder.mAnchorTitle3.setText(list.get(2).getNickname());

        ImageLoadUtil.showImage(mSampleImageLoad
                ,list.get(0).getSmallLogo(), holder.mAnchorImage1);
        ImageLoadUtil.showImage(mSampleImageLoad
                ,list.get(1).getSmallLogo(), holder.mAnchorImage2);
        ImageLoadUtil.showImage(mSampleImageLoad
                ,list.get(2).getSmallLogo(), holder.mAnchorImage3);


        return convertView;
    }


    private static class ViewHolder{

        private TextView mAnchorMainTitle;

        private ImageView mAnchorImage1;
        private ImageView mAnchorImage2;
        private ImageView mAnchorImage3;

        private TextView mAnchorTitle1;
        private TextView mAnchorTitle2;
        private TextView mAnchorTitle3;

    }
}
