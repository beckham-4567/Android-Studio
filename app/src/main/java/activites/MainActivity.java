package activites;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab11.R;

import java.util.ArrayList;
import java.util.List;

import adapters.TankAdapter;
import model.Tank;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TankAdapter tankAdapter;
    List<Tank> tankList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerView);  // Make sure RecyclerView is in your layout (activity_main.xml)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the list and add data
        tankList = new ArrayList<>();
        tankList.add(new Tank("M1 Abrams", "USA", 10, "https://wiki.warthunder.com/images/thumb/c/c0/ArtImage2_M1_Abrams.png/1200px-ArtImage2_M1_Abrams.png"));
        tankList.add(new Tank("T-90M", "USSR", 11, "https://staticfiles.warthunder.com/upload/image/0_2023/12_December/T90M/news_t_90m_19eb04103017b74a574b4bc23929bbd5.jpg"));
        tankList.add(new Tank("Leopard 2A7V", "Germany", 11, "https://forum-en-cdn.warthunder.com/original/2X/0/039919ac348ba7d2c36975e9936289f1e125a015.jpeg"));

        // Set up the adapter
        tankAdapter = new TankAdapter(this, tankList);
        recyclerView.setAdapter(tankAdapter);
    }
}
