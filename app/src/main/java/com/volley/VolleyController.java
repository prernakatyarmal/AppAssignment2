package com.volley;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by prerana_katyarmal on 10/13/2015.
 */
public class VolleyController extends Application {
    private static final String TAG = VolleyController.class.getSimpleName();
    static VolleyController volleyController;
    RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        volleyController = this;
    }


    public static VolleyController getVolleyController() {
        return volleyController;
    }

    /**
     * Creating volley request queue
     * @return
     */
    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;

    }

    /**
     * Adding request to volley request queue
     * @param request
     * @param <T>
     */
    public <T> void addToRequestQue(Request<T>request){
        request.setTag(TAG);
        getRequestQueue().add(request);
    }
    public void cancelAllRequest(Object tag){
        if(requestQueue!=null){
            requestQueue.cancelAll(tag);
        }
    }

}
