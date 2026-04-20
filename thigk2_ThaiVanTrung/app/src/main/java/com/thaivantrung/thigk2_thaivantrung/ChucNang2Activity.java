package com.thaivantrung.thigk2_thaivantrung;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;

public class ChucNang2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        List<String> songs = Arrays.asList(
                "🎵  Tiến Quân Ca",
                "🎵  Như Có Bác Hồ Trong Ngày Vui Đại Thắng",
                "🎵  Giải Phóng Miền Nam",
                "🎵  Bác Đang Cùng Chúng Cháu Hành Quân",
                "🎵  Trường Sơn Đông, Trường Sơn Tây",
                "🎵  Hò Kéo Pháo",
                "🎵  Người Hà Nội",
                "🎵  Cô Gái Mở Đường",
                "🎵  Màu Hoa Đỏ",
                "⭐  Thái Văn Trung  ⭐  (Ca khúc đặc biệt)"
        );

        ListView listView = findViewById(R.id.lv_songs);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, songs);
        listView.setAdapter(adapter);
    }
}