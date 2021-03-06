package com.example.kongalong.ximalaya_mvp.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by kongalong on 2016/11/4.
 */
public class SdCardUtils {

    public static void saveFile(String root, String fileName, byte[] bytes) {

        if(bytes==null){
            return;
        }
        File file = new File(root,fileName);
        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(file);
            fos.write(bytes,0,bytes.length);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }





    public static byte[] getBytesFromFile(String path) {

        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
             fis = new FileInputStream(path);
             baos = new ByteArrayOutputStream();

            int len = 0;
            byte[] buf = new byte[1024*8];
            while((len = fis.read(buf))!=-1){
                baos.write(buf,0,len);
            }

           return baos.toByteArray();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;

    }





}
