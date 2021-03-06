package com.example.gabbygiordano.marketplace;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by gabbygiordano on 7/12/17.
 */

@ParseClassName("Item")
public class Item extends ParseObject {

    // public default constructor for parse
    public Item() {
        super();
    }

    // constructor
    public Item(String name, String description, String price, int condition, ParseUser user, String type,
                ParseFile image, double latitude, double longitude) {
        setItemName(name);
        setDescription(description);
        setPrice("$" + price);
        setCondition(condition);
        setOwner(user);
        setType(type);
        setImage(image);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public String getItemName() {
        return getString("item_name");
    }

    public void setItemName(String itemName) {
        put("item_name", itemName);
    }

    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String description) {
        put("description", description);
    }

    public String getPrice() {
        return getString("price");
    }

    public void setPrice(String price) {
        put("price", price);
    }

    public int getCondition() {
        return getInt("condition");
    }

    public void setCondition(int condition) {
        put("condition", condition);
    }

    public ParseUser getOwner() {
        return getParseUser("owner");
    }

    public void setOwner(ParseUser user) {
        put("owner", user);
    }

    public String getType() {
        return getString("type");
    }

    public void setType(String type) {
        put("type", type);
    }

    public ParseObject getResource() {
        return getParseObject("resource");
    }

    public void setResource(ParseObject resource)
    {
        put("resource", resource);
    }

    public void setImage(ParseFile image) {
        put("image", image);
    }

    public ParseFile getImage() {
        return getParseFile("image");
    }

    public void setLatitude(double latitutde) {
        put("lat", latitutde);
    }

    public double getLatitute() {
        return getDouble("lat");
    }

    public void setLongitude(double longitude) {
        put("long", longitude);
    }

    public double getLongitude() {
        return getDouble("long");
    }

}
