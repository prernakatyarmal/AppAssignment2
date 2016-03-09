package com.assignment2app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.models.Location;
import com.models.Response;
import com.volley.RequestManager;
import com.volley.ResponseListner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ResponseListner {
    private Spinner spinnerName;
    private ArrayList<Response> arryResponse;
    private TextView textViewCarTime;
    private TextView textViewTrainTime;
    private Location location;
    private String locationName;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/**
 * Fetching data from server using volley calls
 */
        RequestManager requestManager = RequestManager.getRequestManagerIntance(MainActivity.this);
        requestManager.createStringRequest(Request.Method.GET, "http://express-it.optusnet.com.au/sample.json", null, 111);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage(getString(R.string.please_wait));
        progressDialog.show();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("LOCATION_FOR_MAP", location);
                bundle.putString("LOCATION_NAME", locationName);
                intent.putExtra("BUNDLE", bundle);
                startActivity(intent);


            }
        });
        inflateXml();
    }

    /**
     * Inflate Xml views and Set Selected listener to Spinner
     */
    private void inflateXml() {
        spinnerName = (Spinner) findViewById(R.id.spinner_name);
        textViewCarTime = (TextView) findViewById(R.id.textview_car_time);
        textViewTrainTime = (TextView) findViewById(R.id.textview_train_time);
        spinnerName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Response response = arryResponse.get(position);
                locationName = response.getName();
                location = response.getLocation();
                Log.v("Selected Item", response.toString());
                textViewCarTime.setText("Car: " + response.getFromcentral().getCar());
                textViewTrainTime.setText("Train: " + response.getFromcentral().getTrain());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    /**
     * Collecting response from volley call
     * @param object
     * @param requestCode
     */
    @Override
    public void onResponseSuccessListner(Object object, int requestCode) {
        if (requestCode == 111) {
            Log.v("Response", object.toString());
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Response>>() {
            }.getType();
            arryResponse = gson.fromJson(object.toString(), listType);
            Log.v("Response", arryResponse.toString());

            com.com.adapter.SpinnerAdapter spinnerAdapter = new com.com.adapter.SpinnerAdapter(MainActivity.this, arryResponse);
            spinnerName.setAdapter(spinnerAdapter);

            progressDialog.dismiss();
        }

    }


    /**
     * If error in response from volley call,It is handled here
     * @param error
     */
    @Override
    public void onErrorListner(VolleyError error) {
        progressDialog.dismiss();
    }

}
