package com.thaivantrung.listview_dsvatlieu;


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

        ImageView imageViewXD = findViewById(R.id.imageViewXD);
        imageViewXD.setImageResource(R.drawable.ic_xaydung);
        //Hiển thị dữ liệu lên ListView
        //B1+: Cần có dữ liệu
        //Ở bài này, ta hardcore dữ liệu trực tiếp
        //cần biến phù hợp để chứa dữ liệu

        ArrayList<String> dsTenVatLieuXD;
        dsTenVatLieuXD = new ArrayList<String>(); //tạo thể hiện cụ thể, thêm mới
        //thêm dữ liệu ở đây
        //nhưng ta hard-code
        dsTenVatLieuXD.add("Xi măng");
        dsTenVatLieuXD.add("Đá ốp lát");
        dsTenVatLieuXD.add("Gạch");
        dsTenVatLieuXD.add("Ống nhựa");
        dsTenVatLieuXD.add("Sơn chống thấm");
        dsTenVatLieuXD.add("Vôi");
        dsTenVatLieuXD.add("Ngói");


        //B2. Tạo adapter
        ArrayAdapter<String> adapterXayDung;
//        adapterXayDung = new ArrayAdapter<String>(this, android.R.layout.item_va, dsTenVatLieuXD);
        adapterXayDung = new ArrayAdapter<String>(this, R.layout.item_vatlieu, dsTenVatLieuXD);

        //B3. Gắn vào điều khiển hiển thị ListView
        ListView lvTenVatLieuXayDung = findViewById(R.id.lvDanhSachVL);

        //3.2. Gắn vào adapter
        lvTenVatLieuXayDung.setAdapter(adapterXayDung);

        //3.3. Lắng nghe và xử lý sự kiện user tương tác

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}