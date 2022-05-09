package com.ufra.edu.museu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "abdomen")
public class Abdomen implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_abdomen;

    @JsonIgnore
    @OneToMany(mappedBy = "abdomen")
    private List<Especies> especies = new ArrayList<>();

    public Abdomen(){

    }

    public Abdomen(Long id, String nome_abdomen) {
        this.id = id;
        this.nome_abdomen = nome_abdomen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_abdomen() {
        return nome_abdomen;
    }

    public void setNome_abdomen(String nome_abdomen) {
        this.nome_abdomen = nome_abdomen;
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
        Abdomen other = (Abdomen) obj;
        return Objects.equals(id, other.id);
    }
}
