/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vitaqresc.controladores;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Gebel
 */
public class AdminRestManager {

    private static AdminRestManager instancia = null;

    public CloseableHttpClient client;
    private CloseableHttpResponse response;

    public AdminRestManager() {
        client = HttpClientBuilder.create().setMaxConnPerRoute(20).setMaxConnTotal(100)
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5 * 1000)
                        .setSocketTimeout(5 * 1000)
                        .setConnectionRequestTimeout(5 * 1000)
                        .build())
                .build();
    }
    
    public int registrarMedico(String nombreCompleto,String cargo,String especialidad,
            String dependencia,String clinicaBase, String consultorio, String cedulaprofesional,
            String modalidadtrabajo, String username, String userpass){
       HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com//admin/registrardoctor");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("nombreCompleto", nombreCompleto));
        nvps.add(new BasicNameValuePair("cargo", cargo));
        nvps.add(new BasicNameValuePair("especialidad", especialidad));
        nvps.add(new BasicNameValuePair("dependencia", dependencia));
        nvps.add(new BasicNameValuePair("clinicaBase", clinicaBase));
        nvps.add(new BasicNameValuePair("consultorio", consultorio));
        nvps.add(new BasicNameValuePair("cedulaprofesional", cedulaprofesional));
        nvps.add(new BasicNameValuePair("modalidadtrabajo", modalidadtrabajo));
        nvps.add(new BasicNameValuePair("username", username));
        nvps.add(new BasicNameValuePair("userpass", userpass));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost);
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        return response.getStatusLine().getStatusCode();
    }

    public static AdminRestManager getInstance() {
        if (instancia == null) {
            instancia = new AdminRestManager();
        }
        return instancia;
    }
}
