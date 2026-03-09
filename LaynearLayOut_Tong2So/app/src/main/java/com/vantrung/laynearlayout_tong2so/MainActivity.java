package com.vantrung.laynearlayout_tong2so;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
        //Khia bao cac doi tuong tuong ung
        EditText editTextSo1;
        EditText editTextSo2;
        EditText editTextKetQua;
        Button nutCong, nutTru, nutNhan, nutChia;

    void TimDieuKhien(){
        editTextSo1 = findViewById(R.id.edtso01);
        editTextSo2 = findViewById(R.id.edtso02);
        editTextKetQua = findViewById(R.id.edtketqua);
        nutCong = (Button) findViewById(R.id.btncong);
        nutTru = (Button) findViewById(R.id.btntru);
        nutNhan = (Button) findViewById(R.id.btnnhan);
        nutChia = (Button) findViewById(R.id.btnchia);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void XuLyCong(View v){
        //Code Xu Ly Cong
        //lay du lieu 2 so
        //tim edittext so 1 va 2
//        EditText editTextSo1 = findViewById(R.id.edtso01);
//        EditText editTextSo2 = findViewById(R.id.edtso02);

        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        //Chuyen du lieu tu chuoi sang so
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);

        //Tinh toan
        float Tong = soA + soB;

        //Hien ket qua
        //Tim edittext ketqua
        EditText editTextKetQua = findViewById(R.id.edtketqua);

        //Xuat dl thanh dang chuoi
        String chuoiKQ = String.valueOf(Tong);

        //gan dl len kq
        editTextKetQua.setText(chuoiKQ);
    }

    public void XuLyTru(View v){
        //Code Xu Ly Tru
        //lay du lieu 2 so
        //tim edittext so 1 va 2
//        EditText editTextSo1 = findViewById(R.id.edtso01);
//        EditText editTextSo2 = findViewById(R.id.edtso02);

        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        //Chuyen du lieu tu chuoi sang so
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);

        //Tinh toan
        float Hieu = soA - soB;

        //Hien ket qua
        //Tim edittext ketqua
        EditText editTextKetQua = findViewById(R.id.edtketqua);

        //Xuat dl thanh dang chuoi
        String chuoiKQ = String.valueOf(Hieu);

        //gan dl len kq
        editTextKetQua.setText(chuoiKQ);
    }

    public void XuLyNhan(View v){
        //Code Xu Ly Nhan
        //lay du lieu 2 so
        //tim edittext so 1 va 2
//        EditText editTextSo1 = findViewById(R.id.edtso01);
//        EditText editTextSo2 = findViewById(R.id.edtso02);

        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        //Chuyen du lieu tu chuoi sang so
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);

        //Tinh toan
        float Thuong = soA * soB;

        //Hien ket qua
        //Tim edittext ketqua
        EditText editTextKetQua = findViewById(R.id.edtketqua);

        //Xuat dl thanh dang chuoi
        String chuoiKQ = String.valueOf(Thuong);

        //gan dl len kq
        editTextKetQua.setText(chuoiKQ);
    }

    public void XuLyChia(View v){
        //Code Xu Ly Chia
        //lay du lieu 2 so
        //tim edittext so 1 va 2
//        EditText editTextSo1 = findViewById(R.id.edtso01);
//        EditText editTextSo2 = findViewById(R.id.edtso02);

        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();

        //Chuyen du lieu tu chuoi sang so
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);

        //Tinh toan
        float Tich = soA / soB;

        //Hien ket qua
        //Tim edittext ketqua
//        EditText editTextKetQua = findViewById(R.id.edtketqua);

        //Xuat dl thanh dang chuoi
        String chuoiKQ = String.valueOf(Tich);

        //gan dl len kq
        editTextKetQua.setText(chuoiKQ);
    }
}