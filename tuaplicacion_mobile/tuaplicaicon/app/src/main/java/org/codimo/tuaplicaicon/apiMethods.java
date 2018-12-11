package org.codimo.tuaplicaicon;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class apiMethods {

    /**
     * MEthod to get json String from url as string parameter
     * @param url
     * @return
     */
    private static String getJson(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            //debug
            System.out.println("----------------- url "+url);

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            System.err.println("---------------------- ERROR InputStream "+ e);
        }

        return result;
    }

    /**
     * Method to convert inputstream information in string
     * @param inputStream
     * @return result
     * @throws IOException
     */
    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    /**
     * return list of user objects (usuarios) build from json returned by url string as string parameter
     * @param url
     * @return list of users
     */
    public static ArrayList<usuarios> listJsonUsers(String url){

        //get json string
        String jsonO = getJson(url);

        ArrayList<usuarios> lu = new ArrayList<>();

        //debug
        System.out.println("------------------ jsonO "+jsonO);

        try {
            //convert json string in json object
            JSONObject json = new JSONObject(jsonO);

            //get json array from result field of json object
            JSONArray ja = (JSONArray) json.getJSONArray("results").get(0);

            for(int i = 0;i<ja.length();i++){
                //each element of json array is a user, get it and create the user object to add to list
                lu.add(new usuarios(ja.getJSONObject(i)));
            }


        } catch (JSONException e) {
            System.err.println("--------------------ERROR listJsonUsers "+e);
        }

        //return list of user object
        return lu;


    }

    /**
     *return user information object (selectedUser) build from json returned by url string as string parameter
     * @param url
     * @return su
     **/
    public static selectedUser jsonUserSelected(String url){

        //get json string
        String jsonO = getJson(url);

        selectedUser  su = null;

        //debug
        System.out.println("------------------ jsonO "+jsonO);

        try {
            //convert json string in json object
            JSONObject json = new JSONObject(jsonO);

            //create user information object from field result of json object
            su = new selectedUser((JSONObject) json.getJSONArray("results").get(0));


        } catch (JSONException e) {
            System.err.println("--------------------ERROR listJsonUsers "+e);
        }

        //return user information object
        return su;


    }


}


