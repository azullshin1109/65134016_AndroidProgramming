package com.thaivantrung.baithigiuaki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BaiThuocAdapter extends BaseAdapter {
    private ArrayList<BaiThuoc> dsBaiThuoc;
    private Context _context;
    private LayoutInflater layoutInflater;

    public BaiThuocAdapter(ArrayList<BaiThuoc> dsBaiThuoc, Context _context) {
        this.dsBaiThuoc = dsBaiThuoc;
        this._context = _context;
        this.layoutInflater = layoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return dsBaiThuoc.size();
    }

    @Override
    public Object getItem(int position) {
        return dsBaiThuoc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewHienHanh = convertView;

        if (viewHienHanh == null)
            viewHienHanh = layoutInflater.inflate(R.layout.item_baithuoc, null);

        BaiThuoc BaiThuocHienTai = dsBaiThuoc.get(position);

        TextView textView_TenBaiThuoc = (TextView) viewHienHanh.findViewById(R.id.txtTenBaiThuoc);
        TextView textView_ThoiGian = (TextView) viewHienHanh.findViewById(R.id.txtThoiGian);
        ImageView imageView_Anh = (ImageView) viewHienHanh.findViewById(R.id.imageAnhThuoc);

        textView_TenBaiThuoc.setText(BaiThuocHienTai.getTenBaiThuoc());
        textView_ThoiGian.setText(BaiThuocHienTai.getThoiGian());
        imageView_Anh.setImageResource(BaiThuocHienTai.getIdAnhMinhHoa());

        return viewHienHanh;
    }
}