package com.example.model;

import javax.persistence.*;

@Entity
public class Tranh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenTacPham;
    private String hoaSi;
    private String namVe;
    private String kichThuoc;
    @ManyToOne
    @JoinColumn(name = "theLoai_id", referencedColumnName = "id")
    private TheLoai theLoai;

    public Tranh() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTacPham() {
        return tenTacPham;
    }

    public void setTenTacPham(String tenTacPham) {
        this.tenTacPham = tenTacPham;
    }

    public String getHoaSi() {
        return hoaSi;
    }

    public void setHoaSi(String hoaSi) {
        this.hoaSi = hoaSi;
    }

    public String getNamVe() {
        return namVe;
    }

    public void setNamVe(String namVe) {
        this.namVe = namVe;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }
}
