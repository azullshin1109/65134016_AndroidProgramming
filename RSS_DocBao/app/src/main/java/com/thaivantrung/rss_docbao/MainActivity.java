package com.thaivantrung.rss_docbao;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


        private RecyclerView rvDanhSachBaiBao;
        private BaiBaoAdapter adapter;
        private ArrayList<ItemBaiBao> danhSachBaiBao;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                EdgeToEdge.enable(this);
                setContentView(R.layout.activity_main);
            // Xử lý padding cho status bar, navigation bar
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            rvDanhSachBaiBao = findViewById(R.id.lvDSBaiBao);
            danhSachBaiBao = new ArrayList<>();
            adapter = new BaiBaoAdapter(this, danhSachBaiBao);
            rvDanhSachBaiBao.setLayoutManager(new LinearLayoutManager(this));
            rvDanhSachBaiBao.setAdapter(adapter);

            // Gọi trong Thread riêng vì Android cấm đọc mạng trên Main Thread
            new Thread(() -> {
                ArrayList<ItemBaiBao> dsFromRSS = LayDuLieuRss.layDuLieu(
                        "https://vnexpress.net/rss/khoa-hoc-cong-nghe.rss");
                runOnUiThread(() -> {
                    danhSachBaiBao.addAll(dsFromRSS);
                    adapter.notifyDataSetChanged();
                });
            }).start();
        }
    }
