package activites;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab11.R;

import java.util.ArrayList;
import java.util.List;

import adapters.ProductAdapter;
import model.Product;

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
        productList.add(new Product(" Smart Watch ", "Gadgets", 1000, "https://mercular.s3.ap-southeast-1.amazonaws.com/images/products/2024/03/Product/hcare-wise-2-smart-watch-blue-front-left-view.jpg"));
        productList.add(new Product("Keyboard", "Gaming", 900, "https://mercular.s3.ap-southeast-1.amazonaws.com/images/products/2023/08/Product/neolution-e-sport-avatar-mechanical-gaming-keyboard%20front.jpg"));

        productAdapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(productAdapter);
    }
}
