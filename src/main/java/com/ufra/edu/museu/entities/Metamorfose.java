package com.ufra.edu.museu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

@Entity
@Table(name = "metamorfose")
public class Metamorfose implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo_metamorfose;
    private String descricao_meta;

    @JsonIgnore
    @OneToMany(mappedBy = "metamorfose")
    private List<Especies> especies = new ArrayList<>();

    public Metamorfose(){

    }

    public Metamorfose(Long id, String tipo_metamorfose, String descricao_meta) {
        this.id = id;
        this.tipo_metamorfose = tipo_metamorfose;
        this.descricao_meta = descricao_meta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_metamorfose() {
        return tipo_metamorfose;
    }

    public void setTipo_metamorfose(String tipo_metamorfose) {
        this.tipo_metamorfose = tipo_metamorfose;
    }

    public String getDescricao_meta() {
        return descricao_meta;
    }

    public void setDescricao_meta(String descricao_meta) {
        this.descricao_meta = descricao_meta;
    }

    public List<Especies> getEspecies() {
        return especies;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Metamorfose other = (Metamorfose) obj;
        return Objects.equals(id, other.id);
    }
}
