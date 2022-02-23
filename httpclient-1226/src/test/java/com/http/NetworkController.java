package com.http;

//import com.zhejiang.kg.processor.TaskRunnable;
//import com.zhejiang.kg.processor.ThreadPoolManager;
import com.thread.TaskRunnable;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import com.thread.ThreadPoolManager;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhouyuanhai on 2018/4/12.
 *
 * http 网络框架
 */
public class NetworkController implements Runnable{

    private static NetworkController mNetworkController = null;
    private Thread httpProcessingThread = null;
    private LinkedBlockingQueue<CommonRequest> requestQueue = null;
    private OkHttpClient httpClient = null;
    private ThreadPoolManager threadPoolManager = null;

    public static NetworkController getInstance(){
        if(mNetworkController == null) mNetworkController = new NetworkController();
        return mNetworkController;
    }

    private NetworkController(){
        requestQueue = new LinkedBlockingQueue<>();
        httpClient = new OkHttpClient.Builder().connectTimeout(3l , TimeUnit.SECONDS).build();
        httpProcessingThread = new Thread(this);
        threadPoolManager = ThreadPoolManager.getInstance();
    }

    /**
     * 异步添加网络请求
     * @param commonRequest
     */
    public synchronized void addToRequestQueue(CommonRequest commonRequest){
        threadPoolManager.addNewTask(new TaskRunnable() {
            @Override
            public void run() {
                if(commonRequest == null) return;

                try {
                    Response response = httpClient.newCall(commonRequest.getRequest()).execute();
                    CommonResponse res = CommonResFactory.dealResponse(response , commonRequest.getResClass());
                    if(res == null){
                        commonRequest.getCallback().onError(new CommonError());
                    }else {
                        commonRequest.getCallback().onResponse(res);
                    }
                }catch (IOException e){
                    commonRequest.getCallback().onError(new CommonError());
                    e.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 同步发送请求
     * @param request
     * @return
     */
    public CommonResponse sendNow(CommonRequest request){
        try {
            Response response = httpClient.newCall(request.getRequest()).execute();
            CommonResponse res = CommonResFactory.dealResponse(response , request.getResClass());
            return res;
        }catch (IOException e){
            return null;
        }
    }


    @Override
    public void run() {

    }
}
