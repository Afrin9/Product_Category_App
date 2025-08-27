package com.example.productcategoryapp;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Product extends RecyclerView.Adapter<Adapter_Product.UserViewHolder> {
    private List<modelProduct> products;
    private Context context;

    public Adapter_Product(List<modelProduct> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {


    }
}
