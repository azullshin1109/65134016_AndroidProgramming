package com.thaivantrung.congvieccanlam2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View; // Thêm cái này
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton; // Thêm cái này
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TASKS> lstVCL;
    TaskRVadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Khai báo danh sách và Firebase
        lstVCL = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("TASKS");
        databaseReference.addValueEventListener(ngheFB);

        // 2. Thiết lập RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rcvVCL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new TaskRVadapter(lstVCL);
        recyclerView.setAdapter(adapter);

        // 3. CODE ĐIỀU KHIỂN NÚT BẤM
        FloatingActionButton btnAdd = findViewById(R.id.floatingActionButton3);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemTaskActivity.class);
                startActivity(intent);
            }
        });
    }


    ValueEventListener ngheFB = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            lstVCL.clear();
            for (DataSnapshot obj : snapshot.getChildren()) {
                TASKS task = obj.getValue(TASKS.class);
                if (task != null) {
                    lstVCL.add(task);
                }
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Log.e("VCL app", "Lỗi: " + error.getMessage());
        }
    };
}