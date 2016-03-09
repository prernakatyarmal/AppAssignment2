package com.models;

import java.io.Serializable;

/**
 * Created by prerana_katyarmal on 3/4/2016.
 */
public class Response implements Serializable{
    private String id;

    private Location location;

    private String name;

    private Fromcentral fromcentral;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Fromcentral getFromcentral ()
    {
        return fromcentral;
    }

    public void setFromcentral (Fromcentral fromcentral)
    {
        this.fromcentral = fromcentral;
    }

    @Override
    public String toString()
    {
        return "Response [id = "+id+", location = "+location+", name = "+name+", fromcentral = "+fromcentral+"]";
    }
}
