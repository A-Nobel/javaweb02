package com.http;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Map;

/**
 * Created by zhouyuanhai on 2018/4/12.
 */
public class CommonRequest {

    private Request mRequest = null;
    private IRequestCallback mCallback = null;
    private Class resClazz = null;

    public static final int GET = 1;
    public static final int POST = 2;

    public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    public CommonRequest(String url , int method , Map<String , String> heads, String body , Class<? extends CommonResponse> clazz , IRequestCallback callback){
        resClazz = clazz;
        mCallback = callback;
        switch (method){
            case GET:{
                mRequest =
                        new Request.Builder()
                                .url(url)
                                .get()
                                .build();
                break;
            }

            case POST:{
                RequestBody requestBody = RequestBody.create(JSON , body);
                mRequest =
                        new Request.Builder()
                                .url(url)
                                .post(requestBody)
                                .build();
                break;
            }
        }

    }


    Request getRequest() {
        return mRequest;
    }

    IRequestCallback getCallback(){
        return mCallback;
    }

    Class getResClass(){
        return resClazz;
    }

    public interface IRequestCallback<T extends CommonResponse>{
        void onResponse(T t);
        void onError(CommonError error);
    }

}
