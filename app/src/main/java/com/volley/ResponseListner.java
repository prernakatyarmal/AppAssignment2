package com.volley;

import com.android.volley.VolleyError;

/**
 * Created by prerana_katyarmal on 10/15/2015.
 */
public interface ResponseListner {
    void onResponseSuccessListner(Object object, int requestCode);
    void onErrorListner(VolleyError error);
}
