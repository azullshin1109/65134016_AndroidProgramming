package com.thaivantrung.rss_docbao;

public class ItemBaiBao {
    String tieuDe;
    String urlAnh;
    String ngayDang;

    public ItemBaiBao(String tieuDe, String urlAnh, String ngayDang) {
        this.tieuDe = tieuDe;
        this.urlAnh = urlAnh;
        this.ngayDang = ngayDang;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getUrlAnh() {
        return urlAnh;
    }

    public void setUrlAnh(String urlAnh) {
        this.urlAnh = urlAnh;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }
}
