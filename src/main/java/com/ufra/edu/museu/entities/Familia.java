package com.ufra.edu.museu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "familia")
public class Familia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "familia")
    private List<Especies> especies = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ordem_id")
    private Ordem ordem;


    @JsonIgnore
    @OneToMany(mappedBy = "familia")
    private List<Genero> generos = new ArrayList<>();

    public  Familia(){

    }

    public Familia(Long id, String nome, Ordem ordem) {
        this.id = id;
        this.nome = nome;
        this.ordem = ordem;
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

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public List<Especies> getEspecies() {
        return especies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Familia familia = (Familia) o;
        return id.equals(familia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
