package com.example.kongalong.day27_home_work.SampleImageLoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.ImageView;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kongalong on 2016/11/7.
 */

public class SampleImageLoad {



    //创建线程池
    public static final ThreadFactory mThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"ImageLoader#" + mCount.getAndIncrement());
        }
    };
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            Constants.CORE_POOL_SIZE,
            Constants.MAX_POOL_SIZE,
            Constants.THREAD_KEEP_ALIVE,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(),
            mThreadFactory
    );


    //使用handler更新ui
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch(msg.what){

                case Constants.MESSAGE_ONE:
                    Obj myObj = (Obj) msg.obj;
                    //判断标记，防止错位
                    if(myObj.mTag.equals((String)myObj.mImageView.getTag())){
                        myObj.mImageView.setImageBitmap(myObj.mBitmap);
                    }

                    break;

            }

        }
    };



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public Bitmap beginLoadBitmap(String url){

        Bitmap bitmap = null;

        //先从lruCache获取
        bitmap = mCache.loadDataFromMem(url);
        if(bitmap!=null){
            Log.d("flag", "beginLoadBitmap: 从内存获取");
            return bitmap;
        }

        //再从disk缓存获取
        bitmap = mCache.loadDataFromDisk(url,mParams.mWidth,mParams.mHeight);
        if(bitmap != null){
            Log.d("flag", "beginLoadBitmap: 从磁盘获取");
            return bitmap;
        }

        //最后从网络加载
        return mLoadImage.laodDataByHttp(url,mCache,mParams.mWidth,mParams.mHeight);

    }


    private Params mParams;
    private LoadImage mLoadImage;
    private Caches mCache;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public SampleImageLoad(Context context){

        //创建图片缓存对象
        mCache = new Caches(context);
        //创建网络加载对象
        mLoadImage = new LoadImage(context);

    }



    public void attachToView(){

        final Params tempParams = mParams;

        //设置标记，防止错位
        tempParams.mImageView.setTag(tempParams.mUri);
        Runnable loadTask = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void run() {
               // Log.d("flag", "initParams: " +params);
                Bitmap bitmap = beginLoadBitmap(tempParams.mUri);
                Obj myObj = new Obj(bitmap,tempParams.mImageView,tempParams.mUri);
                Message msg = mHandler.obtainMessage();
                msg.obj = myObj;
                msg.what = Constants.MESSAGE_ONE;
                mHandler.sendMessage(msg);
            }
        };
        //线程池执行
        THREAD_POOL_EXECUTOR.execute(loadTask);
    }

    public SampleImageLoad initParams(){
        mParams = new Params();

        return this;
    }

    public SampleImageLoad setUrl(String url){

        mParams.mUri = url;
        return this;
    }

    public SampleImageLoad setImageSize(int width,int height){
        mParams.mWidth = width;
        mParams.mHeight = height;
        return this;
    }

    public SampleImageLoad setImageView(ImageView imageView){
        mParams.mImageView = imageView;
        return this;
    }






    //属性参数
   public class Params{

        private String mUri;
        private ImageView mImageView;

        private int mWidth;
        private int mHeight;





        //使用线程池异步加载图片
        // private boolean mAsyncAble = false;


    }

    //通过handler发送 msg.obj
    public class Obj{

        private Bitmap mBitmap;
        private ImageView mImageView;
        private String mTag;

        public Obj(Bitmap bitmap,ImageView imageView,String tag){
            mBitmap = bitmap;
            mImageView = imageView;
            mTag = tag;
        }
    }



  /*  //使用Builder模式 ----------失败
    public static class Builder{


        private Context mContext;

        public Builder(Context context){
            mContext = context;
            mParams = new Params();
        }

        public void setUri(String uri){
            mParams.mUri = uri;
        }

        public void setImageView(ImageView imageView){
            mParams.mImageView = imageView;
        }

        public void setWidth(int width){
            mParams.mWidth = width;
        }

        public void setHeight(int heigth){
            mParams.mHeight = heigth;
        }

       *//* public void setAsyncAble(boolean asyncAble){
            mParams.mAsyncAble = asyncAble;
        }*//*

        //创建SampleImageLoad对象
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
        public SampleImageLoad build(){

            SampleImageLoad sampleImageLoad = new SampleImageLoad(mParams);


            //创建图片缓存对象
            mParams.mCache = new Caches(mContext);
            //创建网络加载对象
            mParams.mLoadImage = new LoadImage(mContext);

            return sampleImageLoad;
        }

    }*/



}
