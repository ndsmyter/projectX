package com.projectx;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: gunther
 * Date: 12-8-13
 * Time: 12:42
 * To change this template use File | Settings | File Templates.
 */
public class httpreq {
    String url = null;
    private final String USER_AGENT = "Mozilla/5.0";

    public httpreq(String url) {
        this.url = url;
    }

    public void sendGet() throws Exception{
        URL link = new URL(url);
        HttpURLConnection con = (HttpURLConnection) link.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());


    }



}
