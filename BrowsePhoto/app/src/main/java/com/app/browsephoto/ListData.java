package com.app.browsephoto;

import java.util.ArrayList;
import java.util.List;

public class ListData {

    String s_FolderName;
    List<ImageData> imageDataList = new ArrayList<>();


    public ListData() {
    }

    public String getS_FolderName() {
        return s_FolderName;
    }

    public void setS_FolderName(String s_FolderName) {
        this.s_FolderName = s_FolderName;
    }

    public List<ImageData> getImageDataList() {
        return imageDataList;
    }

    public void setImageDataList(List<ImageData> imageDataList) {
        this.imageDataList = imageDataList;
    }
}
