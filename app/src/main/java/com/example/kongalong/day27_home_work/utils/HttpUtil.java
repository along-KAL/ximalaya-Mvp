package com.example.kongalong.day27_home_work.utils;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kongalong on 2016/11/10.
 */

public class HttpUtil {


    public static byte[] loadBytes(String path){


       /* InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            URL url = new URL(path);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            if(conn.getResponseCode()==200){
                is = conn.getInputStream();
                baos = new ByteArrayOutputStream();

                int len = 0;
                byte[] buf = new byte[1024*8];

                while((len = is.read(buf))!=-1){
                    baos.write(buf,0,buf.length);
                }

                return baos.toByteArray();

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeIs(is);
            closeOs(baos);
        }
    return null;*/


        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(path).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if(response.isSuccessful()){
            return response.body().bytes();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }










    public static void closeIs(InputStream is){

        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void closeOs(OutputStream os){

        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
