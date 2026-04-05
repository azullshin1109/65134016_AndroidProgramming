package com.thaivantrung.baithigiuaki;

public class BaiThuoc {
    private String tenBaiThuoc;
    private String thoiGian;
    private int idAnhMinhHoa;

    public BaiThuoc(String tenBaiThuoc, String thoiGian, int idAnhMinhHoa) {
        this.tenBaiThuoc = tenBaiThuoc;
        this.thoiGian = thoiGian;
        this.idAnhMinhHoa = idAnhMinhHoa;
    }

    public String getTenBaiThuoc() {
        return tenBaiThuoc;
    }

    public void setTenBaiThuoc(String tenBaiThuoc) {
        this.tenBaiThuoc = tenBaiThuoc;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getIdAnhMinhHoa() {
        return idAnhMinhHoa;
    }

    public void setIdAnhMinhHoa(int idAnhMinhHoa) {
        this.idAnhMinhHoa = idAnhMinhHoa;
    }
}
