package com.thaivantrung.bottomnavigationbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class XepHangAdapter extends ArrayAdapter<XepHangModel> {
    private Context context;
    private List<XepHangModel> xephang;

    public XepHangAdapter(Context context, List<XepHangModel> xephang) {
        super(context, R.layout.item_ungdungxephang, xephang);
        this.context  = context;
        this.xephang = xephang;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_ungdungxephang, parent, false);
            holder = new ViewHolder();
            holder.txtSoThuTu      = convertView.findViewById(R.id.edtNumber);
            holder.imageAnhDaiDien = convertView.findViewById(R.id.imageAnhDaiDien);
            holder.txtUngDung      = convertView.findViewById(R.id.txtUngDung);
            holder.txtDanhGia      = convertView.findViewById(R.id.txtDanhGia);
            holder.txtSoSao        = convertView.findViewById(R.id.txtSoSao);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        XepHangModel item = xephang.get(position);

        holder.txtSoThuTu.setText(String.valueOf(position + 1));
        holder.imageAnhDaiDien.setImageResource(item.getAnhDaiDien());
        holder.txtUngDung.setText(item.getTenUngDung());
        holder.txtDanhGia.setText(item.getDanhMuc());
        holder.txtSoSao.setText(item.getSoSao());

        return convertView;
    }

    static class ViewHolder {
        TextView txtSoThuTu;
        ImageView imageAnhDaiDien;
        TextView  txtUngDung;
        TextView  txtDanhGia;
        TextView  txtSoSao;
    }
}
