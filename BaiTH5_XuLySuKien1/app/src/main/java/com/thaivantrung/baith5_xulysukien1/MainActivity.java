package com.thaivantrung.baith5_xulysukien1;

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

    void TimDieuKhien() {
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
        //Gắn bộ lắng nghe sự kiện và code xử lý cho từng nút
        View.OnClickListener boLangNghecCong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cách 1
//                 //Xử lý Cộng ở đây
//                //Code Xu Ly Cong
//                //lay du lieu 2 so
//                //tim edittext so 1 va 2
//
//                String soThu1 = editTextSo1.getText().toString();
//                String soThu2 = editTextSo2.getText().toString();
//
//                //Chuyen du lieu tu chuoi sang so
//                float soA = Float.parseFloat(soThu1);
//                float soB = Float.parseFloat(soThu2);
//
//                //Tinh toan
//                float Tong = soA + soB;
//
//                //Hien ket qua
//                //Tim edittext ketqua
//                EditText editTextKetQua = findViewById(R.id.edtketqua);
//
//                //Xuat dl thanh dang chuoi
//                String chuoiKQ = String.valueOf(Tong);
//
//                //gan dl len kq
//                editTextKetQua.setText(chuoiKQ);

                //Cách 2:
                //Gọi hàm xử lý cộng
                XULY_CONG();

            }
        };
            //click neen nut cong sau do se goi ham xu ly cong
        nutCong.setOnClickListener(boLangNghecCong);

        nutTru.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Cach1:
//                //Xử lý Trừ ở đây
//                //lay du lieu 2 so
//                //tim edittext so 1 va 2
//
//                String soThu1 = editTextSo1.getText().toString();
//                String soThu2 = editTextSo2.getText().toString();
//
//                //Chuyen du lieu tu chuoi sang so
//                float soA = Float.parseFloat(soThu1);
//                float soB = Float.parseFloat(soThu2);
//
//                //Tinh toan
//                float Hieu = soA - soB;
//
//                //Hien ket qua
//                //Tim edittext ketqua
//                EditText editTextKetQua = findViewById(R.id.edtketqua);
//
//                //Xuat dl thanh dang chuoi
//                String chuoiKQ = String.valueOf(Hieu);
//
//                //gan dl len kq
//                editTextKetQua.setText(chuoiKQ);

                //Cách 2:
                //Gọi hàm xử lý trừ
                XULY_TRU();
            }
        });

        nutNhan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Cach1:
//                //Xử lý Nhân ở đây
//                //lay du lieu 2 so
//                //tim edittext so 1 va 2
//
//
//                String soThu1 = editTextSo1.getText().toString();
//                String soThu2 = editTextSo2.getText().toString();
//
//                //Chuyen du lieu tu chuoi sang so
//                float soA = Float.parseFloat(soThu1);
//                float soB = Float.parseFloat(soThu2);
//
//                //Tinh toan
//                float Thuong = soA * soB;
//
//                //Hien ket qua
//                //Tim edittext ketqua
//                EditText editTextKetQua = findViewById(R.id.edtketqua);
//
//                //Xuat dl thanh dang chuoi
//                String chuoiKQ = String.valueOf(Thuong);
//
//                //gan dl len kq
//                editTextKetQua.setText(chuoiKQ);

                //Cách 2:
                //Gọi hàm xử lý nhân
                XULY_NHAN();
            }
        });

        nutChia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Cach1:
//                //Xử lý Chia ở đây
//                //lay du lieu 2 so
//                //tim edittext so 1 va 2
//
//                String soThu1 = editTextSo1.getText().toString();
//                String soThu2 = editTextSo2.getText().toString();
//
//                //Chuyen du lieu tu chuoi sang so
//                float soA = Float.parseFloat(soThu1);
//                float soB = Float.parseFloat(soThu2);
//
//                //Tinh toan
//                float Tich = soA / soB;
//
//                //Hien ket qua
//                //Tim edittext ketqua
//        //EditText editTextKetQua = findViewById(R.id.edtketqua);
//
//                //Xuat dl thanh dang chuoi
//                String chuoiKQ = String.valueOf(Tich);
//
//                //gan dl len kq
//                editTextKetQua.setText(chuoiKQ);

                //Cách 2:
                //Gọi hàm xử lý chia
                XULY_CHIA();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void XULY_CONG(){
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float tong = num1 + num2;
        String chuoiKQ = String.valueOf(tong);
        editTextKetQua.setText(chuoiKQ);
    }
    void XULY_TRU(){
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float tong = num1 - num2;
        String chuoiKQ = String.valueOf(tong);
        editTextKetQua.setText(chuoiKQ);
    }
    void XULY_NHAN(){
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float tong = num1 * num2;
        String chuoiKQ = String.valueOf(tong);
        editTextKetQua.setText(chuoiKQ);
    }
    void XULY_CHIA(){
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float tong = num1 / num2;
        String chuoiKQ = String.valueOf(tong);
        editTextKetQua.setText(chuoiKQ);
    }
}