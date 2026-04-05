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

public class MonAnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mon_an);

        ImageView imageViewMonAn = findViewById(R.id.imageAnhDaiDien3);
        imageViewMonAn.setImageResource(R.drawable.icon_bacsi);

        ArrayList<String>  dsTenMonAn;
        dsTenMonAn = new ArrayList<String>();

        dsTenMonAn.add("Cơm gà");
        dsTenMonAn.add("Cơm Tấm");
        dsTenMonAn.add("Cơm Chiên");
        dsTenMonAn.add("Phở Gà");
        dsTenMonAn.add("Cơm Bò");
        dsTenMonAn.add("Phở Bò");
        dsTenMonAn.add("Bánh Cuốn");

        ArrayAdapter<String> adapterMonAn;
        adapterMonAn = new ArrayAdapter<String>(this, R.layout.item_monan, dsTenMonAn);

        ListView lvTenMonAn = findViewById(R.id.lvDanhSachMonAn);

        lvTenMonAn.setAdapter(adapterMonAn);

        lvTenMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String monAnChon = dsTenMonAn.get(position);
                Toast.makeText(MonAnActivity.this, monAnChon, Toast.LENGTH_LONG).show();
            }
        });
    }
}