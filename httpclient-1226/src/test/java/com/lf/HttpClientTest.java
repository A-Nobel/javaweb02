package com.lf;

import com.alibaba.fastjson.JSON;
import com.data.TestResponse;
import com.http.CommonError;
import com.http.CommonRequest;
import com.http.CommonResponse;
import com.http.NetworkController;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.*;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.junit.Test;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.util.EntityUtils;
import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

public class HttpClientTest {
    /**
     *参数格式为json的POST请求
     */
//    @Test
//    public void testPost(){
//        //填写接口地址
//        String url = "";
//        //指定接口请求方式
//        HttpPost post = new HttpPost(url);
//        //准备测试数据
//        Map<String,String> parameter = new HashMap<>();
//        parameter.put("phone","13777777777");
//        parameter.put("pwd","123456");
//        //将参数格式化
//        StringEntity entity = new StringEntity(JSON.toJSONString(parameter), "UTF-8");
//        post.setEntity(entity);
//        //创建客户端并发起请求
//        CloseableHttpClient client = HttpClientBuilder.create().build();
//        CloseableHttpResponse response = client.execute(post);
//        //将响应报文转为Map集合
//        JSONObject res = new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
//        res.toMap();
//        //打印响应报文
//        System.out.print("响应状态码：" + response.getStatusLine().getStatusCode());
//        System.out.print("响应报文：" + response.getEntity);
//    }
//
//    /**
//     *参数格式为form的POST请求
//     */
//    @Test
//    public void test(){
//        String url = "";
//        HttpPost post = new HttpPost(url);
//        String phone = "";
//        String pwd = "";
//        List<BasicNameValuePair> parameter = new ArrayList<BasicNameValuePair>();
//        parameter.add(new BasicNameValuePair("phone",phone));
//        parameter.add(new BasicNameValuePair("pwd",pwd));
//        post.setEntity(new UrlEncodeFormEntity(parameter,"UTF-8"));
//        CloseableHttpClient client = HttpClientBuilder.create().build();
//        CloseableHttpResponse response = client.execute(post);
//        JSONObject res = new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
//        res.toMap();
//        System.out.print("响应状态码：" + response.getStatusLine().getStatusCode());
//        System.out.print("响应报文：" + response.getEntity);
//    }





//    public static void main(String[] args) throws Exception {
//        //System.out.println(post());
//        //test1();
//        whenPostRequestUsingHttpClient_thenCorrect();
//        whenPostRequestWithAuthorizationUsingHttpClient_thenCorrect();
//    }


    @Test
    public  void post() throws Exception{
//        System.out.println(postdata("http://10.11.80.221:4000/test/first","{\"name\":\"lf\"}"));
    }

    public String postdata(String url, String body) throws IOException {
        String result = "";
        //创建HttpClient对象
//        HttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        if (body != null) {
//            //解决中文乱码问题
//            StringEntity entity = new StringEntity(body, "utf-8");
//            entity.setContentEncoding("UTF-8");
//            httpPost.setHeader("Content-Type", "application/json");
//            httpPost.setEntity(entity);
//        }
//        //发送post请求
//        HttpResponse response = httpClient.execute(httpPost);
//        StatusLine respHttpStatus = response.getStatusLine();
//        int staus = respHttpStatus.getStatusCode();//获取响应状态码
//        HttpEntity responseBody = response.getEntity();
//        result=EntityUtils.toString(responseBody,"UTF-8");//返回api内容
//        //打印数据到控制台
//        System.out.println("当前get请求，请求地址参数为："+url +"\n请求返回状态为："+staus+"\n请求返回数据为："+result);
        return result;
    }

    @Test
    public void get() throws Exception{
//        String result="";
//        HttpClient client = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("http://10.11.80.221:4000/test/second");
//        HttpResponse response = client.execute(httpGet);
//        System.out.println(response.toString());
    }

    @Test
    public  void test1() throws ClientProtocolException, IOException {
        // 用来保存结果
//        String result;
//        // 新建一个请求对象
//        HttpGet get = new HttpGet("http://www.baidu.com");
//        // 新建一个httpClient 客户端
//        HttpClient client = HttpClients.createDefault();
//        // httpClient 执行请求对象并且返回结果
//        HttpResponse response = client.execute(get);
//        // 把结果以UTF-8形式存在result中
//        result = EntityUtils.toString(response.getEntity(), "utf-8");
//        // 输出结果
//        System.out.println("-------------------------");
//        System.out.println(result);

    }
    @Test
    public  void whenPostRequestUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException {
//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost("http://10.11.80.221:4000/test/first");
//
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("name", "lf"));
//        //params.add(new BasicNameValuePair("password", "pass"));
//        httpPost.setEntity(new UrlEncodedFormEntity(params));
//
//        CloseableHttpResponse response = client.execute(httpPost);
//        String result = EntityUtils.toString(response.getEntity(), "utf-8");
//        System.out.println(result);
//        //assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
//
//        client.close();
    }

    @Test
    public  void whenPostRequestWithAuthorizationUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException, AuthenticationException {
//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost("http://10.11.80.221:4000/test/first");
//
//        httpPost.setEntity(new StringEntity("test post"));
//        UsernamePasswordCredentials creds
//                = new UsernamePasswordCredentials("name", "langfang");
//        httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
//
//        CloseableHttpResponse response = client.execute(httpPost);
//        String result = EntityUtils.toString(response.getEntity(), "utf-8");
//        System.out.println(result);
//        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
//        client.close();
    }

    public static void main(String[] args) {
        httpRequestPost();
        httpRequestGet();
        httpRequestFinally();
    }

   // @Test
    public static void httpRequestPost()  {
        Map<String , Object> params = new HashMap<>();
        params.put("name","lf");

        String body = JSON.toJSONString(params);

        CommonRequest commonRequest = new CommonRequest("http://10.11.80.221:4000/test/first", CommonRequest.POST, null, body, TestResponse.class, new CommonRequest.IRequestCallback<TestResponse>() {
            @Override
            public void onResponse(TestResponse commonResponse) {
                System.out.println("Success!\n"+commonResponse.toString());
            }

            @Override
            public void onError(CommonError error) {
                System.out.println("Error!\n"+error.toString());
            }
        });

        NetworkController.getInstance().addToRequestQueue(commonRequest);
    }

    public static void httpRequestGet()  {
        Map<String , Object> params = new HashMap<>();
        params.put("name","lf");

        String body = JSON.toJSONString(params);

        CommonRequest commonRequest = new CommonRequest("http://10.11.80.221:4000/test/second?name=lf", CommonRequest.GET, null, body, TestResponse.class, new CommonRequest.IRequestCallback<TestResponse>() {
            @Override
            public void onResponse(TestResponse commonResponse) {
                System.out.println("Success!\n"+commonResponse.toString());
            }

            @Override
            public void onError(CommonError error) {
                System.out.println("Error!\n"+error.toString());
            }
        });

        NetworkController.getInstance().addToRequestQueue(commonRequest);
    }

    public static void httpRequestFinally()  {
        Map<String , Object> params = new HashMap<>();
        params.put("name","机器人");
        String body = JSON.toJSONString(params);

        System.out.println("Try to search " + params.get("name") + "...");
        CommonRequest commonRequest = new CommonRequest("http://10.11.80.221:4000/test/finally", CommonRequest.POST, null, body, TestResponse.class, new CommonRequest.IRequestCallback<TestResponse>() {
            @Override
            public void onResponse(TestResponse commonResponse) {
                System.out.println("Success!\n"+commonResponse.toString());
            }

            @Override
            public void onError(CommonError error) {
                System.out.println("Error!\n"+error.toString());
            }
        });

        NetworkController.getInstance().addToRequestQueue(commonRequest);
    }
}


