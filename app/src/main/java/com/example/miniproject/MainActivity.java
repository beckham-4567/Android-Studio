package com.example.miniproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.ProductAdapter;
import Model.Product;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the product list
        productList = new ArrayList<>();
        productList.add(new Product("Smart Watch ", "Gadgets", 1000, "https://mercular.s3.ap-southeast-1.amazonaws.com/images/products/2024/03/Product/hcare-wise-2-smart-watch-blue-front-left-view.jpg"));
        productList.add(new Product("Keyboard", "Gaming Gear", 900, "https://mercular.s3.ap-southeast-1.amazonaws.com/images/products/2023/08/Product/neolution-e-sport-avatar-mechanical-gaming-keyboard%20front.jpg"));
        productList.add(new Product("Headphone", "accessory", 500, "https://sony.scene7.com/is/image/sonyglobalsolutions/wh-ch520_Primary_image?$categorypdpnav$&fmt=png-alpha"));

        productAdapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(productAdapter);
    }
}
