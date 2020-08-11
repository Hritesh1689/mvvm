package com.agicent.mvvmdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemPicResponseById implements Parcelable {

    private String img_3x;
    private String img_2x;

    public ItemPicResponseById(String img_3x, String img_2x) {
        this.img_3x = img_3x;
        this.img_2x = img_2x;
    }

    protected ItemPicResponseById(Parcel in) {
        img_3x = in.readString();
        img_2x = in.readString();
    }

    public static final Creator<ItemPicResponseById> CREATOR = new Creator<ItemPicResponseById>() {
        @Override
        public ItemPicResponseById createFromParcel(Parcel in) {
            return new ItemPicResponseById(in);
        }

        @Override
        public ItemPicResponseById[] newArray(int size) {
            return new ItemPicResponseById[size];
        }
    };

    public String getImg_3x() {
        return img_3x;
    }

    public void setImg_3x(String img_3x) {
        this.img_3x = img_3x;
    }

    public String getImg_2x() {
        return img_2x;
    }

    public void setImg_2x(String img_2x) {
        this.img_2x = img_2x;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(img_3x);
        dest.writeString(img_2x);
    }
}
