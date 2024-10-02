package Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.miniproject.OrderFormActivity;
import com.example.miniproject.R;

import java.util.List;

import Model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productCategory.setText(product.getCategory());
        holder.productPrice.setText("Price : " + product.getPrice());

        Glide.with(context)
                .load(product.getImageUrl())
                .into(holder.productImage);

        holder.productImage.setOnClickListener(v -> {
            // Inflate the custom dialog layout
            View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog, null);

            // Find views in the dialog layout
            ImageView dialogImageView = dialogView.findViewById(R.id.dialog_image_view);
            TextView dialogProductName = dialogView.findViewById(R.id.product_name);
            TextView dialogProductPrice = dialogView.findViewById(R.id.product_price);
            TextView dialogProductDescription = dialogView.findViewById(R.id.product_description);
            Button buyNowButton = dialogView.findViewById(R.id.buy_now_button);

            // Set data to dialog views
            dialogProductName.setText(product.getName());
            dialogProductPrice.setText("Price: " + product.getPrice());
            dialogProductDescription.setText("This is a great product!"); // Replace with actual description
            Glide.with(context).load(product.getImageUrl()).into(dialogImageView);

            // Create and show the dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setView(dialogView)
                    .setPositiveButton("Close", (dialog, which) -> dialog.dismiss());

            AlertDialog dialog = builder.create();
            dialog.show();

            // Handle the Buy Now button
            buyNowButton.setOnClickListener(btnView -> {
                Intent intent = new Intent(context, OrderFormActivity.class);

                // Passing product details to OrderFormActivity
                intent.putExtra("productName", product.getName());
                intent.putExtra("productPrice", product.getPrice());

                context.startActivity(intent);

                // Close the dialog
                dialog.dismiss();
            });
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName, productCategory, productPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.name);
            productCategory = itemView.findViewById(R.id.category);
            productPrice = itemView.findViewById(R.id.price);
        }
    }
}
