package com.ufra.edu.museu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ordem")
public class Ordem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "ordem")
    private List<Especies> especies = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @JsonIgnore
    @OneToMany(mappedBy = "ordem")
    private List<Familia> familias = new ArrayList<>();

    public Ordem() {

    }

    public Ordem(Long id, String nome, Classe classe) {
        this.id = id;
        this.nome = nome;
        this.classe = classe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<Familia> getFamilias() {
        return familias;
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
        Ordem other = (Ordem) obj;
        return Objects.equals(id, other.id);
    }

}
