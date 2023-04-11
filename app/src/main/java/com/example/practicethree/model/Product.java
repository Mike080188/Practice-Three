package com.example.practicethree.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class Product implements Parcelable {

      private String name;
      private String description;
      private String seller;
      private float price;

    private boolean isSelected = false;


    public Product(String name, String seller, float price, String description) {
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.description = description;
    }

    protected Product(Parcel in) {
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


