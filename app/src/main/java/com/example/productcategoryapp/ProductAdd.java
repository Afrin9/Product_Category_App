package com.example.productcategoryapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.util.Calendar;

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
        Expiry_Date.setInputType(InputType.TYPE_NULL);
        Expiry_Date.setFocusable(false);

        //--------- back button-----------
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //-----------back button-------------



        Expiry_Date.setOnClickListener(v -> {
            final Calendar cldr = Calendar.getInstance();
            int day = cldr.get(Calendar.DAY_OF_MONTH);
            int month = cldr.get(Calendar.MONTH);
            int year = cldr.get(Calendar.YEAR);

            DatePickerDialog picker = new DatePickerDialog(ProductAdd.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            Expiry_Date.setText(dayOfMonth + "/"+ (month + 1)+ "/" + year);
                        }
                    }, year, month, day);
            picker.show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // or onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
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