package com.example.productcategoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;

public class ProductAdd extends AppCompatActivity {

    private EditText name, price, description, Expiry_Date;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_add);

        addBtn = findViewById(R.id.addBtn);
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        Expiry_Date = findViewById(R.id.Expiry_Date);
        price =findViewById(R.id.price);

        addBtn.setOnClickListener(view -> saveProduct());
    }

    private void saveProduct(){
        String nameA = name.getText().toString().trim();
        String descriptionA = description.getText().toString().trim();
        String priceA = price.getText().toString().trim();
        String expiryDateA = Expiry_Date.getText().toString().trim();

        if (nameA.isEmpty() || priceA.isEmpty() || descriptionA.isEmpty() || expiryDateA.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        modelProduct product = new modelProduct(nameA, descriptionA, priceA, expiryDateA);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("product", product);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}