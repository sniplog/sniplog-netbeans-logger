/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sniplog.sniploglogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author zieteada
 */
public class SniplogLogger {
    
    public JSONObject sendAction(String action, String id) throws UnsupportedEncodingException, ProtocolException, MalformedURLException, IOException, JSONException {
        
                String urlString = "http://sniplog.it/en/index.php?option=com_ajax&plugin=api&format=json";
        StringBuilder postData = new StringBuilder();
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("action", action);
        params.put("entryId", id);
        
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        
        
        URL url = new URL(urlString);
        HttpURLConnection urlConnection  = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        urlConnection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        urlConnection.setDoOutput(true);
        urlConnection.getOutputStream().write(postDataBytes);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    urlConnection.getInputStream()));
        
    
        
        JSONObject obj = new JSONObject(in.readLine());
        return obj;
        
        
    }
    
    
}
