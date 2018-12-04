package com.app.browsephoto;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class PhotosListAdapter extends RecyclerView.Adapter<PhotosListAdapter.Myviewholder> {
    ArrayList<ListData> arrayList;
    Context context;
    Activity activity;

    GridListAdapter gridListAdapter;

    public PhotosListAdapter(Activity activity, ArrayList<ListData> arrayList) {
        this.context = activity;
        this.activity=activity;
        this.arrayList = arrayList;

    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, parent, false);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;

    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {



        final ListData listData = arrayList.get(position);
        List<ImageData> imageDataList = listData.getImageDataList();

        gridListAdapter = new GridListAdapter(activity, imageDataList);
        holder.gridView.setAdapter(gridListAdapter);

        holder.tv_fname.setText(listData.getS_FolderName());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {


        TextView tv_fname;
        GridlistView gridView;

        public Myviewholder(View itemView) {
            super(itemView);
           // ButterKnife.bind(this, itemView);
            tv_fname = (TextView)itemView.findViewById(R.id.tv_fname);
            gridView = (GridlistView)itemView.findViewById(R.id.gridView);


        }


    }
}
