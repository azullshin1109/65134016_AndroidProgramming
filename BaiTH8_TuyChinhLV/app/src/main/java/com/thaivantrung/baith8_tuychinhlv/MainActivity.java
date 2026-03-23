package com.thaivantrung.baith8_tuychinhlv;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        //Tìm ListView

        ListView lvDSMonAn = (ListView) findViewById(R.id.lvDSMonAn);
        //Chuan bi du nguon du lieu

        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        dsMonAn.add(new MonAn("Bún Mực", 55000, "Bún với mực tươi giòn, nước dùng thanh ngọt, đậm vị biển", R.drawable.bunmuc));
        dsMonAn.add(new MonAn("Phở Gà", 35000, "Phở nước trong, thịt gà mềm, thơm hành lá và rau mùi", R.drawable.phoga));
        dsMonAn.add(new MonAn("Phở Bò", 45000, "Phở nước dùng đậm đà, thịt bò mềm, ăn kèm giá và rau thơm", R.drawable.phobo));
        dsMonAn.add(new MonAn("Bún Bò", 45000, "Bún bò Huế cay nhẹ, nước dùng đậm vị, có chả và thịt bò", R.drawable.bunbo));
        dsMonAn.add(new MonAn("Hủ Tiếu Nam Vang", 55000, "Hủ tiếu nước trong, tôm thịt đầy đủ, vị thanh ngọt", R.drawable.htnamvang));
        dsMonAn.add(new MonAn("Bún Hải Sản", 60000, "Bún với tôm, mực tươi, nước dùng ngọt tự nhiên từ hải sản", R.drawable.bunhaisan));
        dsMonAn.add(new MonAn("Bún Riêu Cua", 55000, "Bún riêu cua đậm đà, có cà chua, đậu hũ và riêu cua", R.drawable.bunrieu));
        dsMonAn.add(new MonAn("Bún Mọc", 55000, "Bún với mọc viên, giò sống, nước dùng thanh nhẹ", R.drawable.bunmoc));
        dsMonAn.add(new MonAn("Bún Nước Lèo", 55000, "Đặc sản miền Tây, nước lèo thơm mắm, ăn kèm cá và rau sống", R.drawable.bunnuocleo));
        dsMonAn.add(new MonAn("Bún Thang", 55000, "Đặc sản Hà Nội, nước dùng trong, có trứng, gà xé, giò lụa", R.drawable.bunthang));
        dsMonAn.add(new MonAn("Bún Mắm Nêm", 35000, "Bún trộn mắm nêm đậm đà, ăn kèm thịt, rau sống và đậu phộng", R.drawable.bunnamnem));

        //
        MonAnAdapter adapter = new MonAnAdapter(dsMonAn, this);
        lvDSMonAn.setAdapter(adapter);


        //Bắt xửv lý sự kiện
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Lay phantu duoc chon
                MonAn monAnChon = dsMonAn.get(position);

                Toast.makeText(MainActivity.this, monAnChon.getTenMonAn(), Toast.LENGTH_LONG).show();

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}