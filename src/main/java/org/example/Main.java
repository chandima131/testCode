package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) {

        try{
            //Open the HTTP Connection
            String api = "https://bored.api.lewagon.com/api/activity/";
            URL url = new URL(api);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //int status = connection.getResponseCode();
           // System.out.println(status);

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String lines;
            StringBuilder content = new StringBuilder();

            while ((lines = br.readLine())!= null){
                content.append(lines);
            }



            JsonObject obj = JsonParser.parseString(content.toString()).getAsJsonObject();
            System.out.println("activity is:" + obj.get("activity"));


        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}