package com.certified.shrine;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.certified.shrine.network.ProductEntry;

import java.util.List;

/**
 * Adapter used to show a simple grid of products.
 */
public class ProductCardRecyclerViewAdapter extends RecyclerView.Adapter<ProductCardViewHolder> {

    private static final String TAG = "ProductCardRecyclerView";
    private List<ProductEntry> productList;
    private Context mContext;

    ProductCardRecyclerViewAdapter(Context context, List<ProductEntry> productList) {
        this.mContext = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shr_product_card, parent, false);
        ProductEntry productEntry = productList.get(0);
        Log.d(TAG, "onCreateViewHolder: Title: " + productEntry.title +
                "\n" + "Price: " + productEntry.price +
                "\n" + "Url: " + productEntry.url);
        return new ProductCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
        if (productList != null && position < productList.size()) {
            ProductEntry product = productList.get(position);
            holder.productTitle.setText(product.title);
            holder.productPrice.setText(product.price);
            Glide.with(mContext)
                    .load(product.url)
                    .into(holder.productImage);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
