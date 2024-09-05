package adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lab11.R;

import java.util.List;

import model.Tank;

public class TankAdapter extends RecyclerView.Adapter<TankAdapter.TankViewHolder> {

    private Context context;
    private List<Tank> tankList;

    public TankAdapter(Context context, List<Tank> tankList) {
        this.context = context;
        this.tankList = tankList;
    }

    @NonNull
    @Override
    public TankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tank_item_layout, parent, false);
        Log.d("TankAdapter", "ViewHolder created for position: " + viewType);
        return new TankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TankViewHolder holder, int position) {
        Tank tank = tankList.get(position);
        holder.tankName.setText(tank.getName());
        holder.tankCountry.setText(tank.getCountry());
        holder.tankRating.setText("Rating: " + tank.getRating());

        // ใช้ Glide ในการโหลดภาพจาก URL
        Glide.with(context)
                .load(tank.getImageUrl())
                .placeholder(R.drawable.t_44)  // ภาพแทนที่ก่อนโหลดภาพ
                .into(holder.tankImage);

        Log.d("TankAdapter", "Binding data for position: " + position + ", Tank: " + tank.getName());

        // เพิ่มการคลิกที่รูปภาพ
        holder.tankImage.setOnClickListener(v -> {
            // สร้าง ImageView สำหรับแสดงภาพใน Dialog
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);  // ใช้ ScaleType ตามความต้องการ

            // ใช้ Glide ในการโหลดภาพจาก URL
            Glide.with(context)
                    .load(tank.getImageUrl())
                    .into(imageView);

            // ตั้งค่า LayoutParams สำหรับ ImageView
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            imageView.setLayoutParams(params);

            // สร้าง AlertDialog.Builder
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(tank.getName())  // ตั้งชื่อให้กับ Dialog
                    .setView(imageView)  // ตั้ง ImageView ให้กับ Dialog
                    .setPositiveButton("Close", (dialog, which) -> dialog.dismiss());  // ปุ่มปิด Dialog

            // แสดง Dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }




    @Override
    public int getItemCount() {
        return tankList.size();
    }

    public static class TankViewHolder extends RecyclerView.ViewHolder {

        ImageView tankImage;
        TextView tankName, tankCountry, tankRating;

        public TankViewHolder(@NonNull View itemView) {
            super(itemView);
            tankImage = itemView.findViewById(R.id.tank_image);
            tankName = itemView.findViewById(R.id.name);
            tankCountry = itemView.findViewById(R.id.country);
            tankRating = itemView.findViewById(R.id.battle_rate);
        }
    }
}
