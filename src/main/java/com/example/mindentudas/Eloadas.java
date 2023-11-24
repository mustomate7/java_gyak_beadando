package com.example.mindentudas;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="eloadas")
public class Eloadas {
    @Id
    private Integer id;
    @Column(name = "cim")
    private String cim;
    @Column(name = "ido")
    private Date ido;

    @OneToOne
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private Kapcsolo kapcsolo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public Date getIdo() {
        return ido;
    }

    public void setIdo(Date ido) {
        this.ido = ido;
    }

    public Kapcsolo getKapcsolo() {
        return kapcsolo;
    }
}
