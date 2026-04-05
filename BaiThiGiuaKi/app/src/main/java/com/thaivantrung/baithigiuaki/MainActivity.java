package com.thaivantrung.baithigiuaki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView imageViewMonAn = findViewById(R.id.imageAnhDaiDien1);
        imageViewMonAn.setImageResource(R.drawable.icon_bacsi);
    }
    public void ChuyenManHinh(View v){
        Intent intent = null;

        if (v.getId() == R.id.btnbmi){
            intent = new Intent(this, BmiActivity.class);
        }
        else if (v.getId() == R.id.btnmonan) {
            intent = new Intent(this, MonAnActivity.class);
        }
        else if (v.getId() == R.id.btnbaithuoc) {
            intent = new Intent(this, BaiThuocActivity.class);
        }
        else if (v.getId() == R.id.btngioithieu) {
            intent = new Intent(this, GioiThieuActivity.class);
        }
        if(intent != null){
            startActivity(intent);
        }
    }


}