package com.example.practicethree.model;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.practicethree.R;

import java.util.ArrayList;
import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);

        holder.nameTextView.setText(product.getName());
        holder.sellerTextView.setText(product.getSeller());
        holder.priceTextView.setText(String.valueOf(product.getPrice()));
//        holder.ratingTextView.setText(String.valueOf(product.getRating()));
        holder.descriptionTextView.setText(product.getDescription());

        holder.selectItemTextView.setBackgroundColor(product.isSelected() ? Color.CYAN : Color.WHITE);
        holder.selectItemTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.setSelected(!product.isSelected());
                holder.selectItemTextView.setBackgroundColor(product.isSelected() ? Color.CYAN : Color.WHITE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public ArrayList<Product> getSelectedProducts() {
        ArrayList<Product> selectedProducts = new ArrayList<Product>();

        for(Product p : products) {
            if (p.isSelected()) {
                selectedProducts.add(p);
            }
        }
        return selectedProducts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, sellerTextView, priceTextView, descriptionTextView, selectItemTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            sellerTextView = itemView.findViewById(R.id.sellerTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
//            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            selectItemTextView = itemView.findViewById(R.id.selectItemTextView);
        }
    }
}

