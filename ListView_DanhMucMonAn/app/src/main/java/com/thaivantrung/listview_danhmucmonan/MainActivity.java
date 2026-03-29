package com.thaivantrung.listview_danhmucmonan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView imageViewXD = findViewById(R.id.imageViewMonAn);
        imageViewXD.setImageResource(R.drawable.ic_daubep);

        ArrayList<String> dsMonAn;
        dsMonAn = new ArrayList<String>();

        dsMonAn.add("Cơm Tấm");
        dsMonAn.add("Phở");
        dsMonAn.add("Mì Tôm");
        dsMonAn.add("Hủ Tiếu");
        dsMonAn.add("Bánh Canh");
        dsMonAn.add("Cháo Gà");
        dsMonAn.add("Cá Chiên");
        dsMonAn.add("Thịt Kho");

        ArrayAdapter<String> adapterMonAn;
        adapterMonAn = new ArrayAdapter<String>(this, R.layout.item_danhmucmonan, dsMonAn);

        ListView lvTenMonAn = findViewById(R.id.lvDanhSachMonAn);

        lvTenMonAn.setAdapter(adapterMonAn);

    }
}