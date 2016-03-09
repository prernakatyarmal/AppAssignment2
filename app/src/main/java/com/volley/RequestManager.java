package com.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prerana_katyarmal on 10/15/2015.
 */
public class RequestManager {

    private static ResponseListner responseListner;
    private static RequestManager requestManager = new RequestManager();
    private int requestCode;

    private RequestManager() {

    }

    public static RequestManager getRequestManagerIntance(ResponseListner responseListner1) {
        responseListner = responseListner1;
        return requestManager;
    }

    /**
     * creating volley request for server call.
     * @param method
     * @param url
     * @param params
     * @param requestCode
     */
    public void createStringRequest(int method, String url, final Map<String, String> params,int requestCode) {
        StringRequest stringRequest = new StringRequest(method, url, createStringRequestListner(), createStringErrorListner()) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (params.size() > 0) {
                    return params;
                }
                return super.getParams();
            }


        };
        this.requestCode=requestCode;
        VolleyController.getVolleyController().addToRequestQue(stringRequest);


    }

    private Response.ErrorListener createStringErrorListner() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseListner.onErrorListner(error);
            }
        };
    }

    /**
     * Adding Volley response listener
     * @return
     */
    private Response.Listener<String> createStringRequestListner() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                responseListner.onResponseSuccessListner(response,requestCode);
            }

        };
    }

}
