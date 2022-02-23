package com.thread;

/**
 * Created by zhouyuanhai on 16/11/8.
 *
 * 属于信号的执行器,使用多线程处理,线程数量与cpu对应能够处理的线程个数有关
 * 如果涉及到分布式计算,那么处理器需要模拟能够连接的多台计算机的处理能力
 * 好在在节点设计的时候考虑到使用RemoteNode来代替分布式计算,从而我们在这里只考虑单机运行的情况
 *
 */
public class ExecuteProcessor {

    private static ExecuteProcessor mExecuteProcessor = null;

    private int currentProcessingTaskCount = 0;



    public static ExecuteProcessor getInstance(){
        if(mExecuteProcessor == null) mExecuteProcessor = new ExecuteProcessor();
        return mExecuteProcessor;
    }

    /////////////////////////////////////////////////////////////////
    //public api

    public int getCurrentProcessingTaskCount(){
        return currentProcessingTaskCount;
    }


    private void executeTaskNow(TaskRunnable taskRunnable){
        ThreadPoolManager.getInstance().addNewTask(taskRunnable);
    }
}
