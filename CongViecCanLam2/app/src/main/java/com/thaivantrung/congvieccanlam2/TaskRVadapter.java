package com.thaivantrung.congvieccanlam2;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskRVadapter extends RecyclerView.Adapter {
    List<TASKS> dataSource;

    public TaskRVadapter(List<TASKS> dataSource) {
        this.dataSource = dataSource;
    }

    //
    public class TaskItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTenVCL;
        TextView tvngayHetHan;

        public int position;
        public TaskItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTenVCL =  itemView.findViewById(R.id.TextViewTenVCL);
            tvngayHetHan = itemView.findViewById(R.id.textThoiGian);
        }

        @Override
        public void onClick(View v) {
            //lay vi tri
            int vtClicked = getAdapterPosition();
            // luc o nguon du lieu
            TASKS taskClicked = dataSource.get(vtClicked);
            //xu ly, vi du o day Toast
            Toast.makeText(v.getContext(), "Ban vua chon viec " + taskClicked.getName(), Toast.LENGTH_SHORT).show();
        }
    }





    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        TaskItemViewHolder viewHolder = new TaskItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        TaskItemViewHolder viewHolder = (TaskItemViewHolder) holder;
        viewHolder.position = position;
        TASKS task = dataSource.get(position);
        ((TaskItemViewHolder) holder).tvTenVCL.setText(task.getName());
        ((TaskItemViewHolder) holder).tvngayHetHan.setText(task.getDate());

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}