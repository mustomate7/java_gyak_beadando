package com.example.mindentudas;

import jakarta.persistence.*;

@Entity
@Table(name="kapcsolo")
public class Kapcsolo {
    @Id
    private Integer id;
    @Column(name = "tudosid")
    private Integer tudosid;
    @Column(name = "eloadasid")
    private Integer eloadasid;

    @OneToOne
    @JoinColumn(name = "tudosid", insertable=false, updatable=false)
    private Tudos tudos;

    @OneToOne
    @JoinColumn(name = "eloadasid", insertable=false, updatable=false)
    private Eloadas eloadas;

    public Eloadas getEloadas() {
        return eloadas;
    }
    public Tudos getTudos() {
        return tudos;
    }
}
