package com.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by zhouyuanhai on 2018/4/12.
 */
public class CommonResponse {

    private String message = null;

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    private boolean isSuccess = false;
    private int code = 200;

    ///////////////////////////////////////////////////////////////////////////////////
    public CommonResponse(String json){
        initCommonData(json);
    }

    private void initCommonData(String json){
        JSONObject jsonObject = JSON.parseObject(json);

        //System.out.println(jsonObject.toString());
        try{
            message = jsonObject.getString("message");
            code = jsonObject.getIntValue("code");
            isSuccess = jsonObject.getBooleanValue("success");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }


}
