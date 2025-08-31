package com.example.productcategoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter_Product.OnItemClickListener {

    private RecyclerView recyclerView;
    private FloatingActionButton fabBtn;
    private TextView emptytext;

    private final List<modelProduct> productList = new ArrayList<>();
    private Adapter_Product adapterProduct;
    private ActivityResultLauncher<Intent> addProductLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fabBtn = findViewById(R.id.fabBtn);
        recyclerView = findViewById(R.id.recyclerView);
        emptytext = findViewById(R.id.emptytext);

        // Initialize adapter with click listener
        adapterProduct = new Adapter_Product(productList, this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterProduct);

        addProductLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        if(data != null){
                            modelProduct product = (modelProduct) data.getSerializableExtra("product");

                            if(product != null){
                                adapterProduct.addProduct(product);

                                emptytext.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }
        );

        fabBtn.setOnClickListener(view -> {
                    Intent intent = new Intent(MainActivity.this, ProductAdd.class);
                    addProductLauncher.launch(intent);
                }
        );

        updateEmptyView();
    }

    private void updateEmptyView() {
        if (productList.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptytext.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptytext.setVisibility(View.GONE);
        }
    }

    // Handle item clicks from the adapter
    @Override
    public void onItemClick(modelProduct product) {
        // Launch ProductDetailActivity with the clicked product
        Intent intent = new Intent(this, ProductDetails.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}



