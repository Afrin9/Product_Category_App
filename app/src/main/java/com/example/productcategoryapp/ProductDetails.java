package com.example.productcategoryapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetails extends AppCompatActivity {

    private TextView nameD, descriptionD, priceD, Expiry_DateD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_details);

        nameD = findViewById(R.id.nameD);
        descriptionD = findViewById(R.id.descriptionD);
        priceD = findViewById(R.id.priceD);
        Expiry_DateD = findViewById(R.id.Expiry_DateD);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



        modelProduct product = (modelProduct) getIntent().getSerializableExtra("product");

        if(product!= null){
            nameD.setText(product.getName());
            descriptionD.setText(product.getDescription());
            priceD.setText("$" +product.getPrice());
            Expiry_DateD.setText( product.getExpiry_date());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // or onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}