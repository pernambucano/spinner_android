package com.sodet.paulofernandes.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulofernandes on 8/27/15.
 */
public class MySpinnerAdapter extends BaseAdapter {

    private String[] array;


    public MySpinnerAdapter (String[] array){
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.length -1;
    }

    @Override
    public Object getItem(int position) {
        return array[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null || !convertView.getTag().toString().equals("NON_DROPDOWN")) {
            //Eh novo, tem que criar
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.spinner_item_actionbar, parent, false);
            convertView.setTag("NON_DROPDOWN");
        }

        if (position == getCount())
        {
            ((TextView) convertView.findViewById(android.R.id.text1)).setText("");
            ((TextView) convertView.findViewById(android.R.id.text1)).setHint(getItem(getCount()).toString());
        }
        else
        {
            TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
            textView.setText(getTitle(position));
        }
//        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
//        textView.setText(getTitle(position));
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null || !convertView.getTag().toString().equals("DROPDOWN")) {
            //Eh novo, tem que criar
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.spinner_item_dropdown, parent, false);
            convertView.setTag("DROPDOWN");
        }
        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(getTitle(position));
        return convertView;
    }

    public String getTitle(int position) {
        return array[position];
    }
}
