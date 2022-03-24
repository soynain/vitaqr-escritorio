/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vitaqresc.vistas;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Gebel
 */
public class Prueba {

    public static void main(String[] args) throws IOException, InterruptedException {
        BasicCookieStore cookieStore = new BasicCookieStore();
        HttpClientContext context = HttpClientContext.create();
        context.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
        /*CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response = client.execute(new HttpGet("http://192.168.100.6:3000/medico/login"));
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statuscode);*/
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom()
                    .setCookieSpec(CookieSpecs.STANDARD).build()).build();
        HttpPost httpPost = new HttpPost("http://192.168.100.6:3000/medico/login");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("usuario", "doctor"));
        nvps.add(new BasicNameValuePair("contra", "1234"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response = client.execute(httpPost,context);
        CookieStore cookieStore2 = context.getCookieStore();
      //  Cookie customCookie = cookieStore2.getCookies();
        System.out.println(cookieStore2);
        
        
        System.out.println(response.getStatusLine().getStatusCode());
        response.close();
    }
}
