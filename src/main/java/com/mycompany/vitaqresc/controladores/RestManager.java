/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vitaqresc.controladores;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Gebel
 */
public class RestManager {

    private static RestManager instancia = null;
    private BasicCookieStore cookieStore;
    private HttpClientContext context;
    public CloseableHttpClient client;
    private CloseableHttpResponse response;
    private CookieStore cookieStore2;
  

    public RestManager() {
        cookieStore = new BasicCookieStore();
        context = HttpClientContext.create();
        context.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
        client = HttpClientBuilder.create().setMaxConnPerRoute(20).setMaxConnTotal(100)
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD)
                        .setConnectTimeout(5 * 1000)
                        .setSocketTimeout(5 * 1000)
                        .setConnectionRequestTimeout(5 * 1000)
                        .build())
                .build();
    }

    public static RestManager getInstance() {
        if (instancia == null) {
            instancia = new RestManager();
        }
        return instancia;
    }

    public int iniciarSesion(String usuario, String contra) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/login");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("usuario", usuario));
        nvps.add(new BasicNameValuePair("contra", contra));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public String registrarNuevoPaciente(String nombres, String apellidos, String usuario, String userpass, String fechaNac,
            String sexo, String altura, String peso, String numTelefono, String donanteorg) throws IOException {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/registrarnuevopaciente");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("nombres", nombres));
        nvps.add(new BasicNameValuePair("apellidos", apellidos));
        nvps.add(new BasicNameValuePair("usuario", usuario));
        nvps.add(new BasicNameValuePair("userpass", userpass));
        nvps.add(new BasicNameValuePair("fechaNac", fechaNac));
        nvps.add(new BasicNameValuePair("sexo", sexo));
        nvps.add(new BasicNameValuePair("altura", altura));
        nvps.add(new BasicNameValuePair("peso", peso));
        nvps.add(new BasicNameValuePair("numTelefono", numTelefono));
        nvps.add(new BasicNameValuePair("donanteorg", donanteorg));
        nvps.add(new BasicNameValuePair("usuario", usuario));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //   cookieStore2 = context.getCookieStore();
        HttpEntity entity = response.getEntity();
        // System.out.println(EntityUtils.toString(entity));
        return EntityUtils.toString(entity);
    }

    public int añadirAlergia(String listaJsonAlergias) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/registraralergia");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("ListaAlergias", listaJsonAlergias));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int añadirPadecimientos(String listaJsonPadecimientos) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/registrarpadecimiento");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("ListaPadecimientos", listaJsonPadecimientos));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int añadirMedicamentos(String listaJsonMedicamentos) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/registrarmedicamento");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("ListaMedicamentos", listaJsonMedicamentos));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int actualizarInfoPersonalPac(String fechaNac, String sexo, String altura, String peso,
            String numTelefono, String donanteOrg, String idUsuarioSeleccionado) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/mod-datos-paciente");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("fechaNac", fechaNac));
        nvps.add(new BasicNameValuePair("sexo", sexo));
        nvps.add(new BasicNameValuePair("altura", altura));
        nvps.add(new BasicNameValuePair("peso", peso));
        nvps.add(new BasicNameValuePair("numTelefono", numTelefono));
        nvps.add(new BasicNameValuePair("donanteOrg", donanteOrg));
        nvps.add(new BasicNameValuePair("idUsuarioSeleccionado", idUsuarioSeleccionado));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int darDeBajaPacienteSeleccionado(String idPulsera, String motivoBaja) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/paciente-baja");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("idPulsera", idPulsera));
        nvps.add(new BasicNameValuePair("motivoBaja", motivoBaja));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int registrarNuevaCita(String fechahoracita, String motivocita, String idPaciente) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/registrarcita");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("fechahoracita", fechahoracita));
        nvps.add(new BasicNameValuePair("motivocita", motivocita));
        nvps.add(new BasicNameValuePair("idPaciente", idPaciente));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    /*idRow hace referencia a la fila para actualizar*/
    public int actualizarPadecimiento(String idRow, String jsonPadecimientoAModificar) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/actualizar-padecimiento");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("Padecimiento", jsonPadecimientoAModificar));
        nvps.add(new BasicNameValuePair("idRow", idRow));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int actualizarAlergia(String idRow, String jsonAlergiaAModificar) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/actualizar-alergia");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("Alergia", jsonAlergiaAModificar));
        nvps.add(new BasicNameValuePair("idRow", idRow));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int actualizarMedicamento(String idRow, String jsonMedicamentoAModificar) {
        //System.out.println(idRow);
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/actualizar-medicamento");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("Medicamento", jsonMedicamentoAModificar));
        nvps.add(new BasicNameValuePair("idRow", idRow));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int eliminarPadecimiento(String idRow) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/borrar-padecimiento");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("idRow", idRow));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int eliminarAlergia(String idRow) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/borrar-alergia");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("idRow", idRow));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int eliminarMedicamento(String idRow) {
        HttpPost httpPost = new HttpPost("https://vitaqr.herokuapp.com/medico/borrar-medicamento");
        ArrayList<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("idRow", idRow));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        try {
            response = client.execute(httpPost, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public int cerrarSesion() {
        HttpGet httpGet = new HttpGet("https://vitaqr.herokuapp.com/medico/logout");
        try {
            response = client.execute(httpGet, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " b " + ex.getMessage());
        }
        //     cookieStore2 = context.getCookieStore();
        return response.getStatusLine().getStatusCode();
    }

    public String obtenerListaPacientesAsignados() throws IOException {
        HttpGet httpGet = new HttpGet("https://vitaqr.herokuapp.com/medico/listapacientes");
        try {
            response = client.execute(httpGet, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        HttpEntity entity = response.getEntity();
        // System.out.println(EntityUtils.toString(entity));
        return EntityUtils.toString(entity);
    }

    public String obtenerDatosMedico() throws IOException {
        HttpGet httpGet = new HttpGet("https://vitaqr.herokuapp.com/medico/datosdoctor");
        try {
            response = client.execute(httpGet, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        HttpEntity entity = response.getEntity();
        // System.out.println(EntityUtils.toString(entity));
        return EntityUtils.toString(entity);
    }

    public String obtenerHistorialCitasPaciente(String idPrim) throws IOException {
        HttpGet httpGet = new HttpGet("https://vitaqr.herokuapp.com/medico/listacitas");
        httpGet.addHeader("idPrim", idPrim);
        try {
            response = client.execute(httpGet, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        HttpEntity entity = response.getEntity();
        // System.out.println(EntityUtils.toString(entity));
        return EntityUtils.toString(entity);
    }

    public String obtenerListaPadecimientos(String idPrim) throws IOException {
        HttpGet httpGet = new HttpGet("https://vitaqr.herokuapp.com/medico/listapadecimientos");
        httpGet.addHeader("idPrim", idPrim);
        try {
            response = client.execute(httpGet, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        HttpEntity entity = response.getEntity();
        // System.out.println(EntityUtils.toString(entity));
        return EntityUtils.toString(entity);
    }

    public String obtenerListaAlergias(String idPrim) throws IOException {
        HttpGet httpGet = new HttpGet("https://vitaqr.herokuapp.com/medico/listaalergias");
        httpGet.addHeader("idPrim", idPrim);
        try {
            response = client.execute(httpGet, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        HttpEntity entity = response.getEntity();
        // System.out.println(EntityUtils.toString(entity));
        return EntityUtils.toString(entity);
    }

    public String obtenerListaMedicamentos(String idPrim) throws IOException {
        HttpGet httpGet = new HttpGet("https://vitaqr.herokuapp.com/medico/listamedicamentos");
        httpGet.addHeader("idPrim", idPrim);
        try {
            response = client.execute(httpGet, context);
            System.out.println(response.getStatusLine() + " " + response.getEntity());
        } catch (IOException ex) {
            System.out.println(ex.getCause() + " a " + ex.getMessage());
        }
        HttpEntity entity = response.getEntity();
        // System.out.println(EntityUtils.toString(entity));
        return EntityUtils.toString(entity);
    }

}
