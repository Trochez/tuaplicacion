package org.codimo.tuaplicaicon;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class that represent the basic user information
 */
public class usuarios {

    //variables that store the fields of user object
    private String first;
    private String last;
    private String email;


    //geters methods

    public String getFirst() {

        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Constructor to set each field with string parameter
     * @param first
     * @param last
     * @param email
     */
    public usuarios(String first, String last, String email) {

        this.first = first;
        this.last = last;
        this.email = email;
    }

    /**
     * Constructor to define each field from json object
     * @param jo
     */
    public usuarios(JSONObject jo){

        try {
            this.first = jo.getString("first");
            this.last = jo.getString("last");
            this.email = jo.getString("email");
        } catch (JSONException e) {
            System.err.println("--------------- ERROR JSON not contain field");
        }

    }

    /**
     * override method toString to show the information of user in list of specifc way
     * @return string
     */
    @Override
    public String toString() {
        return first+" "+last+" \n"+email;
    }
}
