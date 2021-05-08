package com.example.retrofitgetput.data.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Display;

import com.google.gson.annotations.SerializedName;

public class Model {
    public Model(String title) {
        this.title = title;
    }

    public Model(int id) {
        this.id = id;
    }

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
