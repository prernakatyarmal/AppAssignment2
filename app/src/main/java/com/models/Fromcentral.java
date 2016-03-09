package com.models;

import java.io.Serializable;

/**
 * Created by prerana_katyarmal on 3/4/2016.
 */
public class Fromcentral implements Serializable
{
    private String car;

    private String train;

    public String getCar ()
    {
        return car;
    }

    public void setCar (String car)
    {
        this.car = car;
    }

    public String getTrain ()
    {
        return train;
    }

    public void setTrain (String train)
    {
        this.train = train;
    }

    @Override
    public String toString()
    {
        return "Fromcentral [car = "+car+", train = "+train+"]";
    }
}



