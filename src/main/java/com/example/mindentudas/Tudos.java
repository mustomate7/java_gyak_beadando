package com.example.mindentudas;

import jakarta.persistence.*;

@Entity
@Table(name="tudos")
public class Tudos {
    @Id
    private Integer id;
    @Column(name = "nev")
    private String nev;
    @Column(name = "terulet")
    private String terulet;

    @OneToOne
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private Kapcsolo kapcsolo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTerulet() {
        return terulet;
    }

    public void setTerulet(String terulet) {
        this.terulet = terulet;
    }

    public Kapcsolo getKapcsolo() {
        return kapcsolo;
    }
}
