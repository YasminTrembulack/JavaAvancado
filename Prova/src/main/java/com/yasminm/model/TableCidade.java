package com.yasminm.model;

import javax.persistence.*;

@Entity
@Table(name = "TableCidade")
public class TableCidade {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "Cidade")
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "Estado") // nome da coluna que será a foreign key
    private TableEstado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public TableEstado getEstado() {
        return estado;
    }

    public void setEstado(TableEstado estado) {
        this.estado = estado;
    }
    
}
