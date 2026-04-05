package com.thaivantrung.bottomnavigationbar;

public class XepHangModel {
    private String tenUngDung;
    private String danhMuc;
    private String soSao;
    private int anhDaiDien;

    public XepHangModel(String tenUngDung, String danhMuc, String soSao, int anhDaiDien) {
        this.tenUngDung = tenUngDung;
        this.danhMuc = danhMuc;
        this.soSao = soSao;
        this.anhDaiDien = anhDaiDien;
    }

    public String getTenUngDung() {
        return tenUngDung;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public String getSoSao() {
        return soSao;
    }

    public int getAnhDaiDien() {
        return anhDaiDien;
    }
}
