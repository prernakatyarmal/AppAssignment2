package com.models;

import java.io.Serializable;

/**
 * Created by prerana_katyarmal on 3/4/2016.
 */
public class Location implements Serializable{
        private String longitude;

        private String latitude;

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [longitude = "+longitude+", latitude = "+latitude+"]";
    }
}
