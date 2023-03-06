package com.example.dto;

import com.example.model.TheLoai;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class TranhDto implements Validator {
    private int id;

    @NotBlank(message = "không để trống !")
    private String tenTacPham;

    @NotBlank(message = "không để trống !")
    private String hoaSi;

    @NotBlank(message = "không để trống !")
    private String namVe;

    private TheLoai theLoai;
    @NotBlank(message = "không để trống !")

    private String kichThuoc;

    public TranhDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
