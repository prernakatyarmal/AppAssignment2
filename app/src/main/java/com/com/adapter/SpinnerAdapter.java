package com.com.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.assignment2app.R;
import com.models.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prerana_katyarmal on 3/5/2016.
 */
public class SpinnerAdapter extends BaseAdapter {
    private ArrayList<Response> responseList;
    private Context context;
    View v;

    public SpinnerAdapter(Context context, ArrayList<Response> reponseList) {
        this.context = context;
        this.responseList = reponseList;

    }

    @Override
    public int getCount() {
        return responseList.size();
    }

    @Override
    public Object getItem(int position) {
        return responseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) context).getLayoutInflater().inflate(R.layout.spinner_layout, null);
        }
        TextView texview_name = (TextView) convertView.findViewById(R.id.textview_name);
        texview_name.setText(responseList.get(position).getName());
        return convertView;
    }
}
