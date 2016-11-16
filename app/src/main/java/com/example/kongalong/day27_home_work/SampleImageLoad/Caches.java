package com.example.kongalong.day27_home_work.SampleImageLoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.LruCache;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kongalong on 2016/11/8.
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class Caches {

    private Context mContext;

    private DiskLruCache mDiskLruCache;
    private LruCache<String,Bitmap> mLruCache;




    //是否创建了disk缓存
    public boolean isCreateDiskCache = false;

    public Caches(Context context){


        mContext = context;
        //
        initCaches(context);

}

    /**
     * 初始化缓存
     */
    public void initCaches(Context context){

        //分配进程内存1/8大小当作缓存
        int memCacheSize = (int) (Runtime.getRuntime().maxMemory()/1024/8);
        //初始化lruCache
        mLruCache = new LruCache<String, Bitmap>(memCacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //计算图片大小
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };

        //获取disk缓存文件夹
        File diskCacheFile = Utils.getDiskCacheFile(context, Constants.DISK_CACHE_FILE_NAME);
        //如果disk空间足够就创建disk缓存

        if(Utils.getAvailableSpace(diskCacheFile)>Constants.DISK_CACHE_SIZE){
            try {

                mDiskLruCache = DiskLruCache.open(diskCacheFile,1,1,Constants.DISK_CACHE_SIZE);

                isCreateDiskCache = true;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    /**
     * 下面是四个数据存取方法
     */
        public Bitmap loadDataFromMem(String url){
            String key = Utils.getkeyFromUrl(url);
            return mLruCache.get(key);
        }

        public void saveDataToMem(String url,Bitmap bitmap){
            String key = Utils.getkeyFromUrl(url);
            if(mLruCache.get(key)==null){
                mLruCache.put(key,bitmap);
            }

        }

        public Bitmap loadDataFromDisk(String url,int width,int height){

            if(!isCreateDiskCache){
                return null;
            }

            Bitmap bitmap = null;
            String key = Utils.getkeyFromUrl(url);
            BufferedInputStream bis = null;
            ByteArrayOutputStream baos = null;
            try {

                DiskLruCache.Snapshot snapshot = mDiskLruCache.get(key);

                if(snapshot!=null){
                    //通过snapshot获取输入流，即可获取byte数组
                    InputStream is = snapshot.getInputStream(Constants.DISK_CACHE_INDEX);
                    bis = new BufferedInputStream(is);
                    baos = new ByteArrayOutputStream();
                    int len = 0;
                    byte[] buf = new byte[Constants.BYTE_BUFFER_SIZE];
                    while((len = bis.read(buf))!=-1){
                        baos.write(buf,0,buf.length);
                    }
                    //压缩图片
                    bitmap = CompressBitmap.compressFromBytes(baos.toByteArray(), width, height);

                    if(bitmap!=null){
                        //保存到内存
                        saveDataToMem(url,bitmap);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                Utils.closeIs(bis);
                Utils.closeOs(baos);
            }
            return bitmap;
        }

        public void saveDataToDisk(String url, byte[] bytes){

            String key = Utils.getkeyFromUrl(url);
            BufferedOutputStream bos = null;
            try {
                OutputStream os = null;
                DiskLruCache.Editor edit = mDiskLruCache.edit(key);
                if(edit!=null){
                    os = edit.newOutputStream(Constants.DISK_CACHE_INDEX);
                    bos = new BufferedOutputStream(os);
                    bos.write(bytes,0,bytes.length);
                    //提交
                    edit.commit();
                    mDiskLruCache.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                Utils.closeOs(bos);
            }


        }


}
