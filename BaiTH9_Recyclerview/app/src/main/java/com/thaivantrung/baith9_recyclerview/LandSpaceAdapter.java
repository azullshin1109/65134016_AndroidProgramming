package com.thaivantrung.baith9_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandSpaceAdapter extends RecyclerView.Adapter<LandSpaceAdapter.ItemLandHolder>{
    Context context;
    ArrayList<LandSpace> lstData;

    public LandSpaceAdapter(Context context, ArrayList<LandSpace> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land,parent, false);
        ItemLandHolder viewholderCreated = new ItemLandHolder(vItem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //lấy đối tượng hiển thị
        LandSpace landScapeHienThi = lstData.get(position);
        // Trích thông tin
        String caption = landScapeHienThi.getLandCation();
        String tenFileAnh = landScapeHienThi.getLandImageFileName();
        // Đặt vào các trường thông tin của holder
        holder.tvCapTion.setText(caption);
        // đặt ảnh
        String packageName =holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", packageName);
        holder.ivLandSpace.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return  lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder{
        TextView tvCapTion;
        ImageView ivLandSpace;
        public ItemLandHolder(@NonNull View itemView){
            super(itemView);
            tvCapTion = itemView.findViewById(R.id.txvCation);
            ivLandSpace = itemView.findViewById(R.id.imageViewLand);
        }
    }
}
