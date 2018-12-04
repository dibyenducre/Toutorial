package com.app.browsephoto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class GridListAdapter extends BaseAdapter {

    Context context;
    List<ImageData> data;
    ArrayList<ImageData> objects;

    public GridListAdapter(Context context, List<ImageData> data) {
        this.context = context;
        this.data = data;
        this.objects = new ArrayList<ImageData>();
        this.objects.addAll(data);

    }

    /*private view holder class*/
    private class ViewHolder {

        ImageView img_photos;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;


        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_image, null);
            holder = new ViewHolder();

            holder.img_photos = (ImageView)convertView.findViewById(R.id.img_photos);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        final ImageData datas = (ImageData) getItem(position);

        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher);
        Glide.with(context).load(datas.getS_ImagePath()).apply(options).into(holder.img_photos);




        return convertView;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.indexOf(getItem(position));
    }


    /*// Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length() == 0) {
            data.addAll(objects);
        }
        else
        {
            for (AgentData wp : objects)
            {
                if (wp.getSname().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    data.add(wp);
                }*//*else if(wp.getPhoneNumner().toLowerCase(Locale.getDefault()).contains(charText)){
                    data.add(wp);
                }*//*
            }
        }
        notifyDataSetChanged();
    }*/


}