package com.app.browsephoto;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhotosActivity extends AppCompatActivity {

    RecyclerView list_photos;
    PhotosListAdapter adapter;

    ArrayList<ListData> listDataArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        list_photos = (RecyclerView)findViewById(R.id.list_photos);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        list_photos.setLayoutManager(mLayoutManager);

        adapter = new PhotosListAdapter(this, listDataArrayList);
        list_photos.setAdapter(adapter);

        if(hasStoragePermission()) {
            generateList();
        }else {
            requestStoragePermission();
        }



    }


    public void generateList(){


        List<String> listOfAllImages = getImagefromDevice(this);
        Log.d("====",""+listOfAllImages.size());

        String f_name = "";

        List<String> folderNameStringList = new ArrayList<>();

        for (int i = 0; i<listOfAllImages.size(); i++){

            String absoulatePathOfImage = listOfAllImages.get(i);
            String folderName = getFolderNameFromPath(absoulatePathOfImage);


            if(f_name.equals("")){

                f_name = folderName;
                if(!folderNameStringList.contains(folderName))
                {folderNameStringList.add(folderName);}

            }else {

                if(!f_name.equals(folderName)){

                    f_name = folderName;
                    if(!folderNameStringList.contains(folderName))
                    {folderNameStringList.add(folderName);}

                }

            }

            Log.d(">>>IMAGE>>",""+absoulatePathOfImage);
        }
        populateList(folderNameStringList);


    }

    public void populateList(List<String> listOfFolder){
        listDataArrayList.clear();
        for (int i = 0; i<listOfFolder.size();i++){

            ListData listData  = new ListData();

            listData.setS_FolderName(listOfFolder.get(i));
            listData.setImageDataList(getImageListByFolderName(listOfFolder.get(i)));

            listDataArrayList.add(listData);
        }

        adapter.notifyDataSetChanged();

    }

    public List<ImageData> getImageListByFolderName(String f_name){

        List<String> listOfAllImages = getImagefromDevice(this);

        List<ImageData> imageDataList = new ArrayList<>();

        for (int i = 0; i<listOfAllImages.size(); i++){

            String absoulatePathOfImage = listOfAllImages.get(i);
            String file_name = getFileNameFromPath(absoulatePathOfImage);
            //Log.d(">>>FILE NAME--",file_name);

            if(absoulatePathOfImage.contains("/"+f_name+"/"+file_name)){

                ImageData imageData = new ImageData();
                imageData.setS_ImagePath(absoulatePathOfImage);
                imageDataList.add(imageData);

            }

        }


        return imageDataList;

    }

    //From Here you will get the list of images from internal and external directory.
    public ArrayList<String> getImagefromDevice(Activity activity){

        Uri uri;
        Cursor cursor;
        int column_index_data,column_index_folder_name;
        ArrayList<String> listOfAllImages = new ArrayList<String>();
        String absoulatePathOfImage = null;
        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};
        cursor = activity.getContentResolver().query(uri,projection,null,null,null);
        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

        while (cursor.moveToNext()){

            absoulatePathOfImage = cursor.getString(column_index_data);
            listOfAllImages.add(absoulatePathOfImage);

        }



        return listOfAllImages;

    }



    private boolean hasStoragePermission() {
        return ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestStoragePermission() {
        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                100 );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 100 :

                generateList();

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }



    public String getFolderNameFromPath(String path){

        File file = new File(path);
        String dir = file.getParent().substring(file.getParent().lastIndexOf(File.separator) + 1);//page01

        return dir;

    }

    public String getFileNameFromPath(String path){

        String filename=path.substring(path.lastIndexOf("/")+1);
        return filename;

    }

}
