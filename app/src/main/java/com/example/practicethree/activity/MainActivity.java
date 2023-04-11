package com.example.practicethree.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicethree.R;
import com.example.practicethree.database.ProductDatabaseHelper;
import com.example.practicethree.model.Product;
import com.example.practicethree.model.ProductAdapter;
import com.example.practicethree.model.SpacingItemDecorator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private ProductDatabaseHelper databaseHelper;
    private ProductAdapter productAdapter;
    private Button mButtonProductSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Instantiate the UI elements */
        mRecyclerView = findViewById(R.id.recycler_view);
        mButtonProductSelection = findViewById(R.id.button_select_products);

        /** Create an instance of the ProductDataBaseHelpter to manipulate the database */
        databaseHelper = new ProductDatabaseHelper(this);

        List<Product> products;
        /** Create an intent to recover the String passed as parameter in the previous activity **/
        Intent intent = getIntent();
        String option_selected = (String) intent.getStringExtra("option_selected");

        /** Check if the database is empty. If so, we need to populate it, and get All the products */
        if(databaseHelper.isDatabaseEmpty()){
            databaseHelper.populateProductsDatabase();
        }

        products = databaseHelper.getAllProducts();

        /** We have a populated list of products. Next, we need to configure the adapter,
         *  and assign a product adapter to the RecyclerView */
        productAdapter = new ProductAdapter(products);
        mRecyclerView.setAdapter(productAdapter);
        mRecyclerView.addItemDecoration(new SpacingItemDecorator(0));
        /** The RecyclerView needs a LayoutManager to draw the objects. It will be responsible for
         * measuring and positioning each item view within the RecyclerView*/
        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        mButtonProductSelection.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ArrayList<Product> selectedProducts = productAdapter.getSelectedProducts();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putParcelableArrayListExtra("selectedProducts", selectedProducts);
                startActivity(intent);
            }
        });
    }

}