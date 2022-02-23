package com.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.http.CommonResponse;

public class TestResponse extends CommonResponse {

    private JSONObject jsonObject;
    public TestResponse(String json){
        super(json);

        this.jsonObject = JSON.parseObject(json);
    }

    public String toString(){
        return jsonObject.toString();
    }
}
