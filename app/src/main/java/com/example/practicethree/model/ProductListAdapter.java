package com.example.practicethree.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practicethree.R;

import java.util.List;

public class ProductListAdapter extends ArrayAdapter<Product> {

    public ProductListAdapter(@NonNull Context context, @NonNull List<Product> objects) {
       super(context, R.layout.product_list_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listViewElement = convertView;

        if (listViewElement == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listViewElement = inflater.inflate(R.layout.product_list_item, parent, false);
        }

        Product product = getItem(position);
        TextView textViewName = listViewElement.findViewById(R.id.nameTextViewListForList);
        TextView textViewSeller = listViewElement.findViewById(R.id.sellerTextViewForList);
        TextView textViewPrice = listViewElement.findViewById(R.id.priceTextViewForList);
        TextView textViewDescription = listViewElement.findViewById(R.id.descriptionTextViewForList);


        textViewName.setText(product.getName());
        textViewSeller.setText(product.getSeller());
        textViewPrice.setText(String.valueOf(product.getPrice()));
        textViewDescription.setText(product.getDescription());

        return listViewElement;

    }
}
