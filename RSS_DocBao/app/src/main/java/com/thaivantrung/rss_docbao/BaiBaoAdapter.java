package com.thaivantrung.rss_docbao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class BaiBaoAdapter extends RecyclerView.Adapter<BaiBaoAdapter.ViewHolder> {

    Context context;
    ArrayList<ItemBaiBao> danhSach;

    public BaiBaoAdapter(Context context, ArrayList<ItemBaiBao> danhSach) {
        this.context = context;
        this.danhSach = danhSach;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_baibao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemBaiBao bai = danhSach.get(position);

        holder.tvTieuDe.setText(bai.getTieuDe());
        holder.tvNgayDang.setText(formatNgay(bai.getNgayDang()));

        // Dùng Glide để tải ảnh từ URL
        Glide.with(context)
                .load(bai.getUrlAnh())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(holder.ivAnh);
    }

    private String formatNgay(String ngayRSS) {
        try {
            java.text.SimpleDateFormat inputFormat =
                    new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);
            java.text.SimpleDateFormat outputFormat =
                    new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm", java.util.Locale.getDefault());
            java.util.Date date = inputFormat.parse(ngayRSS);
            return outputFormat.format(date);
        } catch (Exception e) {
            return ngayRSS; // Nếu lỗi thì trả về nguyên gốc
        }
    }

    @Override
    public int getItemCount() {
        return danhSach.size();
    }

    // ViewHolder chứa các view của 1 dòng item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAnh;
        TextView tvTieuDe, tvNgayDang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAnh      = itemView.findViewById(R.id.ivAnh);
            tvTieuDe   = itemView.findViewById(R.id.tvTieuDe);
            tvNgayDang = itemView.findViewById(R.id.tvNgayDang);
        }
    }
}