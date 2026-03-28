package com.thaivantrung.baith9_recyclerview;

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
    LandSpaceAdapter landScapeAdapter;

    ArrayList<LandSpace> recylerViewDatas;

    RecyclerView recyclerViewLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //3
        recylerViewDatas = getDataForRecyclerView();
        //4
        recyclerViewLandscape = findViewById(R.id.recyclerland);
        //5
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLandscape.setLayoutManager(layoutLinear);
        //6
        landScapeAdapter = new LandSpaceAdapter(this, recylerViewDatas);
        //7
        recyclerViewLandscape.setAdapter(landScapeAdapter);
    }
    ArrayList<LandSpace> getDataForRecyclerView (){
            ArrayList<LandSpace> dsDuLieu = new ArrayList<LandSpace>();
            LandSpace landSpace1 = new LandSpace("dulich_phuyen", "Phú Yên");
            dsDuLieu.add(landSpace1);
            dsDuLieu.add(new LandSpace("dulich_nhatrang", "Nha Trang"));
            dsDuLieu.add(new LandSpace("dl_danang", "Đà Nẵng"));
            dsDuLieu.add(new LandSpace("dulich_hanoi", "Hà Nội"));
            dsDuLieu.add(new LandSpace("dulich_hagiang", "Hà Giang"));
            dsDuLieu.add(new LandSpace("dulich_yenbai", "Yên Bái"));
            return dsDuLieu;
        }
    }
