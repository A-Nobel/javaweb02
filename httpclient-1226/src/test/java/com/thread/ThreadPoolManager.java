package com.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhouyuanhai on 16/11/8.
 *
 * 线程池管理器
 */
public class ThreadPoolManager {

    private ThreadPoolExecutor mThreadPool = null;
    private BlockingDeque<Runnable> taskQueue = null;

    private static ThreadPoolManager mThreadPoolManager = null;


    ////////////////////////////////////////////////////////
    //const
    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors() / 2;
    private static final int NUMBER_OF_MAX_THREADS = Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_PERIOD = 1000; //ms


    ////////////////////////////////////////////////////////
    //constructor
    public static ThreadPoolManager getInstance(){
        synchronized (ThreadPoolManager.class) {
            if (mThreadPoolManager == null) mThreadPoolManager = new ThreadPoolManager();
        }

        return mThreadPoolManager;
    }

    private ThreadPoolManager(){
        if(taskQueue == null) {
            taskQueue = new LinkedBlockingDeque<>();
        }
        if(mThreadPool == null) {
            mThreadPool = new ThreadPoolExecutor(NUMBER_OF_CORES , NUMBER_OF_MAX_THREADS , KEEP_ALIVE_PERIOD , TimeUnit.MILLISECONDS , taskQueue);
        }
    }


    ////////////////////////////////////////////////////////
    //public api

    public void stopExecutor(){
        if(mThreadPool != null) mThreadPool.shutdown();
    }

    public void stopExecutorNow(){
        if(mThreadPool != null) mThreadPool.shutdownNow();
    }

    public synchronized void addNewTask(TaskRunnable taskRunnable){
        if(mThreadPool != null) mThreadPool.execute(taskRunnable);
    }

    public synchronized boolean isBlockingQueueFull(){
//        System.out.println("blocking queue:" + taskQueue.size());
//        System.out.println("max core :" + NUMBER_OF_MAX_THREADS);

        return taskQueue.size() > NUMBER_OF_MAX_THREADS * 2? true : false;
    }
}
