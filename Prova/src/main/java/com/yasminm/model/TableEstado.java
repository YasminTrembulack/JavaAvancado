package com.yasminm.model;

import javax.persistence.*;

@Entity
@Table(name = "TableEstado")
public class TableEstado {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "Estado")
    private String estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
