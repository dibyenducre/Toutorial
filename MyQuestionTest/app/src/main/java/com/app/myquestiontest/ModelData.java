package com.app.myquestiontest;

import java.io.Serializable;

public class ModelData implements Serializable {

    String name;

    public ModelData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
