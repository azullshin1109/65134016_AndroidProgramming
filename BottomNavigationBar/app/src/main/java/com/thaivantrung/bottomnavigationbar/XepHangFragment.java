package com.thaivantrung.bottomnavigationbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class XepHangFragment extends Fragment {



    public XepHangFragment() {
        // Required empty public constructor
    }

    public static XepHangFragment newInstance(String param1, String param2) {
        XepHangFragment fragment = new XepHangFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xep_hang, container, false);
        ListView listView = view.findViewById(R.id.lvXepHang);

        List<XepHangModel> xephang = new ArrayList<>();
        xephang.add(new XepHangModel("ChatGPT",  "Năng suất • Nền tảng AI", "4,7",  R.drawable.ic_chatgpt));
        xephang.add(new XepHangModel("VNeID", "Năng suất • Du lịch và địa phương", "3,4",  R.drawable.ic_vneid));
        xephang.add(new XepHangModel("TikTok Lite - Tiết kiệm bộ nhớ", "Xã hội • Xây dựng mối quan hệ","4,1", R.drawable.ic_tiktok));
        xephang.add(new XepHangModel("Shopee 4.4 Siêu Hội Voucher","Mua sắm • Chợ trực tuyến","4,2", R.drawable.ic_shopee));
        xephang.add(new XepHangModel("PineDrama", "Giải trí", "4,1", R.drawable.ic_pdrama));
        xephang.add(new XepHangModel("TikTok", "Xem và sửa video • Xã hội","Đã cài đặt",R.drawable.ic_tiktok));
        xephang.add(new XepHangModel("iCPV - Book", "Công cụ","3,8",  R.drawable.ic_icpv));
        xephang.add(new XepHangModel("CapCut - Chỉnh sửa video","Trình phát và chỉnh sửa video ", "3,8",  R.drawable.ic_capcut));
        listView.setAdapter(new XepHangAdapter(requireContext(), xephang));
        return view;
    }
}