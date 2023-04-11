package com.example.practicethree.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Product implements Parcelable {
//    private int year;
//    private float rating;
//    private String description;
//    private String title;
//    private String category;

//      private String id;
      private String name;
      private String description;
      private String seller;
      private float price;

    private boolean isSelected = false;

//    public Product(String title, String category, int year, float rating, String description) {
//        this.title = title;
//        this.category = category;
//        this.year = year;
//        this.rating = rating;
//        this.description = description;
//    }
    public Product(String name, String seller, float price, String description) {
//        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.description = description;
    }

    protected Product(Parcel in) {
//        id = in.readString();
        name = in.readString();
        seller = in.readString();
        price = in.readFloat();
        description = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /** Getters and Setters */
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSelected(boolean selected) {
          isSelected = selected;
    }

    public boolean isSelected() {
          return isSelected;
    }


    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
//        dest.writeInt(year);
        dest.writeString(name);
        dest.writeString(seller);
        dest.writeFloat(price);
        dest.writeString(description);
    }

    private void readFromParcel(Parcel in) {
          name = in.readString();
          price = in.readFloat();
          seller = in.readString();
          description = in.readString();
    }
}


