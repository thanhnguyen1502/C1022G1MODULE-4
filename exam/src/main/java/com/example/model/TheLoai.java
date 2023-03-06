package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenTheLoai;
    @OneToMany(mappedBy = "theLoai")
    private List<Tranh> tranhList;

    public TheLoai() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public List<Tranh> getTranhList() {
        return tranhList;
    }

    public void setTranhList(List<Tranh> tranhList) {
        this.tranhList = tranhList;
    }
}
