package com.ufra.edu.museu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "antenas")
public class Antenas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_antena;

    @JsonIgnore
    @OneToMany(mappedBy = "antenas")
    private List<Especies> especies = new ArrayList<>();

    public Antenas(){

    }

    public Antenas(Long id, String nome_antena) {
        this.id = id;
        this.nome_antena = nome_antena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_antena() {
        return nome_antena;
    }

    public void setNome_antena(String nome_antena) {
        this.nome_antena = nome_antena;
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
        Antenas other = (Antenas) obj;
        return Objects.equals(id, other.id);
    }
}
