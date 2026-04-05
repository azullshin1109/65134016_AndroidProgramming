package com.thaivantrung.baithigiuaki;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BaiThuocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_thuoc);

        ImageView imageViewMonAn = findViewById(R.id.imageAnhDaiDien2);
        imageViewMonAn.setImageResource(R.drawable.icon_bacsi);

        ListView lvDSBaiThuoc = (ListView) findViewById(R.id.lvDsBaiThuoc);

        ArrayList<BaiThuoc> dsBaiThuoc = new ArrayList<BaiThuoc>();
        dsBaiThuoc.add(new BaiThuoc("Nature Made Super B Complex", "1-2 viên mỗi ngày", R.drawable.nmsbc));
        dsBaiThuoc.add(new BaiThuoc("Dynamogen", "Dùng 1 ống, uống 2 lần mỗi ngày", R.drawable.dynamogen));
        dsBaiThuoc.add(new BaiThuoc("Fatig Abbott", "1 đến 3 ống mỗi ngày", R.drawable.fatig));
        dsBaiThuoc.add(new BaiThuoc("A.T ZinC", "Dựa vào chỉ định của bác sĩ", R.drawable.at));
        dsBaiThuoc.add(new BaiThuoc("Procare Pregnancy Breastfeeding", "1 viên mỗi ngày", R.drawable.ppb));
        dsBaiThuoc.add(new BaiThuoc("Magne B6 Corbiere", "6-8 viên mỗi ngày", R.drawable.mbc));

        BaiThuocAdapter adapter = new BaiThuocAdapter(dsBaiThuoc, this);
        lvDSBaiThuoc.setAdapter(adapter);

        lvDSBaiThuoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BaiThuoc baiThuocChon = dsBaiThuoc.get(position);
                Toast.makeText(BaiThuocActivity.this, baiThuocChon.getTenBaiThuoc(), Toast.LENGTH_LONG).show();
            }
        });
    }
}