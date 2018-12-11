package org.codimo.tuaplicaicon;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class that represent the user specific information
 */
public class selectedUser {

    //variables to store the name parts
    private String title;
    private String first;
    private String last;

    //variable to store number phone
    private String phone;

    //variable to store the address parts
    private String street;
    private String city;
    private String state;
    private String picture;


    /**
     * Constructor with each field as string parameter
     * @param title
     * @param first
     * @param last
     * @param phone
     * @param street
     * @param city
     * @param state
     * @param picture
     */
    public selectedUser(String title, String first, String last, String phone, String street, String city, String state, String picture) {
        this.title = title;
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.picture = picture;
    }

    /**
     * Constructor to define each field from json object
     * @param jo
     */
    public selectedUser(JSONObject jo){

        try {
            this.title = jo.getJSONObject("name").getString("title");
            this.first = jo.getJSONObject("name").getString("first");
            this.last = jo.getJSONObject("name").getString("last");
            this.phone = jo.getString("phone");
            this.street = jo.getJSONObject("location").getString("street");
            this.city = jo.getJSONObject("location").getString("city");
            this.state = jo.getJSONObject("location").getString("state");
            this.picture = jo.getJSONObject("picture").getString("thumbnail");
        } catch (JSONException e) {
            System.err.println("---------------- ERROR field not found selectedUser "+e);
        }


    }

    //Geters methods

    public String getTitle() {

        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }


    public String getPicture() {
        return picture;
    }

    /**
     * Method to return a complete name with all parts (title, first and last)
     * @return composed name
     */
    public String getComposedName(){
        return title+" "+first+" "+last;
    }

    /**
     * Method to retorn a complete address with all parts (state, city and street)
     * @return composed address
     */
    public String getComposedAddress(){
        return state+", "+city+", \n"+street;
    }
}
