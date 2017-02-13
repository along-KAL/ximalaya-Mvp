package com.example.kongalong.ximalaya_mvp.imageLoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**网络加载
 * Created by kongalong on 2016/11/8.
 */

public class LoadImage {

    private Context mContext;


    public LoadImage(Context context) {

        mContext = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public Bitmap laodDataByHttp(String path, Caches diskCache, int width, int height){
        Log.d("flag", "beginLoadBitmap: 从网络获取");
        InputStream bis = null;
        ByteArrayOutputStream baos = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(Constants.TIME_OUT);
            if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){

                bis = new BufferedInputStream(conn.getInputStream());
                baos = new ByteArrayOutputStream();

                int len = 0;
                byte[] buf = new byte[Constants.BYTE_BUFFER_SIZE];
                while((len = bis.read(buf))!=-1){
                    baos.write(buf,0,len);
                }
                byte[] data = baos.toByteArray();
                Bitmap bitmap = CompressBitmap.compressFromBytes(data, width, height);
                //保存到caches缓存);

                if(diskCache.isCreateDiskCache){
                    diskCache.saveDataToDisk(path, data);
                }
                diskCache.saveDataToMem(path,bitmap);
                //返回压缩后的图片
                return bitmap;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();
            Utils.closeOs(baos);
            Utils.closeIs(bis);
        }
        return null;
    }

/*    public static Bitmap laodDataByHttp(String path, Caches diskCache, int width, int height){

        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            if(connection.getResponseCode()==200){

                is = connection.getInputStream();
                baos = new ByteArrayOutputStream();
                int len = 0;
                byte[] buf = new byte[1024*8];
                while((len = is.read(buf))!= -1){
                    baos.write(buf,0,len);
                }
                byte[] bytes = baos.toByteArray();
                return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            Utils.closeIs(is);
            Utils.closeOs(baos);
        }
        return null;

    }*/
}
