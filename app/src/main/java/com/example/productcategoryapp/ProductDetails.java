package com.example.productcategoryapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameD = findViewById(R.id.nameD);
        descriptionD = findViewById(R.id.descriptionD);
        priceD = findViewById(R.id.priceD);
        Expiry_DateD = findViewById(R.id.Expiry_DateD);

        modelProduct product = (modelProduct) getIntent().getSerializableExtra("product");

        if(product!= null){
            nameD.setText(product.getName());
            descriptionD.setText(product.getDescription());
            priceD.setText("Price: "+product.getPrice()+"$");
            Expiry_DateD.setText( product.getExpiry_date());
        }

    }
}