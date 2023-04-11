package com.example.practicethree.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practicethree.R;
import com.example.practicethree.model.Product;
import com.example.practicethree.model.ProductListAdapter;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<Product> selectedProducts;
    private ProductListAdapter productListAdapter;
    private ListView mListViewProducts;
    private Button mButtonEmailProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        selectedProducts = getIntent().getParcelableArrayListExtra("selectedProducts");

        productListAdapter = new ProductListAdapter(SecondActivity.this, selectedProducts);

        mListViewProducts = findViewById(R.id.listview_products);
        mListViewProducts.setAdapter(productListAdapter);

        mButtonEmailProducts = findViewById(R.id.button_email_products);

        mButtonEmailProducts.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendEmail();
            }
        });
    }

    private void sendEmail(){
        String subject = "Product Information";
        String email = "sweng888mobileapps@gmail.com";
        String message = buildEmailBody();


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(Intent.createChooser(intent, "Send mail..."), 0);
        }
    }

    protected String buildEmailBody() {
        String body = "";

        for(Product product : this.selectedProducts) {
            body += product.getName() + "\r\n";
            body += product.getSeller() + "\r\n";
            body += product.getDescription() + "\r\n";
            body += product.getPrice() + "\r\n\r\n";
        }

        return body;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode  == 0) { // Activity.RESULT_OK
            Toast.makeText(SecondActivity.this, "Your message has been sent successfully.", Toast.LENGTH_LONG).show();
            selectedProducts = new ArrayList<Product>();

//          Reset ListView
            productListAdapter = new ProductListAdapter(SecondActivity.this, new ArrayList<Product>());
            mListViewProducts.setAdapter(productListAdapter);
        }

    }
}