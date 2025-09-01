package com.example.productcategoryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Product extends RecyclerView.Adapter<Adapter_Product.ProductViewHolder> {
    private final List<modelProduct> localproductsList;
    private final OnItemClickListener itemClickListener;
    private final Context context;

    public interface OnItemClickListener {
        void onItemClick(modelProduct product);
    }

    public Adapter_Product(List<modelProduct> productsList, Context context, OnItemClickListener listener) {
        this.localproductsList = productsList;
        this.context = context;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        modelProduct product = localproductsList.get(position);
        holder.name.setText(product.getName());
        holder.description.setText(product.getDescription());
        holder.price.setText("$"+ product.getPrice());
        holder.expiry_date.setText(product.getExpiry_date());

        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localproductsList.size();
    }

    public void addProduct(modelProduct product) {
        localproductsList.add(product);
        notifyItemInserted(localproductsList.size() - 1);
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price, expiry_date;

        public ProductViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.pName);
            description = itemView.findViewById(R.id.pdescription);
            price = itemView.findViewById(R.id.pPrice);
            expiry_date = itemView.findViewById(R.id.pexpiry);
        }
    }
}