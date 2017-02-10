package com.example.kongalong.ximalaya_mvp.SampleImageLoad;

/**
 * Created by kongalong on 2016/11/8.
 */

public class Constants {

    //disk缓存文件夹名称
    public static final String DISK_CACHE_FILE_NAME = "bitmapCache";

    //disk缓存大小
    public static final int DISK_CACHE_SIZE = 1024*1024*50;

    public static final int DISK_CACHE_INDEX = 0;

    //请求超时
    public static final int TIME_OUT = 5000;

    //字节流缓存大小
    public static final int BYTE_BUFFER_SIZE = 1024*8;

    //Message的what值
    public static final int MESSAGE_ONE = 1;

    //cup个数
    public static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    //核心线程池大小
    public static final int CORE_POOL_SIZE = CPU_COUNT + 1;

    //最大线程池大小
    public static final int MAX_POOL_SIZE = CPU_COUNT * 2 + 1;

    //线程能活多久
    public static final long THREAD_KEEP_ALIVE = 10L;
}
