package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User
{
    public String name;
    public String screenName;
    public String profileImageUrl;
    public long uid;

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.screenName = jsonObject.getString("screen_name");
        user.profileImageUrl = jsonObject.getString("profile_image_url_https");
        user.uid = jsonObject.getLong("id");
        return user;
    }
}