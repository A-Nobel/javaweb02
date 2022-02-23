package com.http;


import com.data.TestResponse;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by zhouyuanhai on 2018/4/12.
 */
public class CommonResFactory {

    static CommonResponse dealResponse(Response response , Class clazz){
        String json = null;

        try {
            json = response.body().string();

            if(clazz == TestResponse.class) {
                return new TestResponse(json);
            }
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
