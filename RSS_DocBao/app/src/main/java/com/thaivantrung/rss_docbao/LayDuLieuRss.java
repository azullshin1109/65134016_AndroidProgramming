package com.thaivantrung.rss_docbao;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class LayDuLieuRss {

    public static ArrayList<ItemBaiBao> layDuLieu(String urlString) {
        ArrayList<ItemBaiBao> danhSach = new ArrayList<>();

        try {
            // Kết nối tới URL RSS
            HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.connect();

            // Đọc XML từ luồng dữ liệu
            InputStream stream = conn.getInputStream();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(stream, null);

            String tieuDe = "", urlAnh = "", ngayDang = "";
            String tagHienTai = "";
            boolean dangTrongItem = false;

            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {

                String tag = parser.getName();

                if (event == XmlPullParser.START_TAG) {
                    tagHienTai = tag;

                    if ("item".equals(tag)) {
                        // Bắt đầu 1 bài báo mới → reset dữ liệu
                        dangTrongItem = true;
                        tieuDe = ""; urlAnh = ""; ngayDang = "";

                    } else if (dangTrongItem) {
                        // Thử lấy ảnh từ thuộc tính url (enclosure, media:content)
                        String attrUrl = parser.getAttributeValue(null, "url");
                        if (attrUrl != null && !attrUrl.isEmpty()) {
                            urlAnh = attrUrl;
                        }
                    }

                } else if (event == XmlPullParser.TEXT || event == XmlPullParser.CDSECT) {
                    if (dangTrongItem) {
                        String text = parser.getText();
                        if (text != null) text = text.trim();

                        if ("title".equals(tagHienTai)) {
                            tieuDe = text;
                        } else if ("pubDate".equals(tagHienTai)) {
                            ngayDang = text;
                        } else if ("description".equals(tagHienTai) && urlAnh.isEmpty()) {
                            // Nếu chưa có ảnh thì tìm trong phần mô tả HTML
                            urlAnh = layUrlAnhTuHtml(text);
                        }
                    }

                } else if (event == XmlPullParser.END_TAG) {
                    if ("item".equals(tag)) {
                        // Kết thúc 1 bài báo → thêm vào danh sách
                        danhSach.add(new ItemBaiBao(tieuDe, urlAnh, ngayDang));
                        dangTrongItem = false;
                    }
                    tagHienTai = "";
                }

                event = parser.next();
            }

            stream.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSach;
    }

    // Tìm link ảnh trong chuỗi HTML
    private static String layUrlAnhTuHtml(String html) {
        try {
            int vitri = html.indexOf("src=\"");
            if (vitri != -1) {
                int batDau = vitri + 5;
                int ketThuc = html.indexOf("\"", batDau);
                if (ketThuc > batDau) return html.substring(batDau, ketThuc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}