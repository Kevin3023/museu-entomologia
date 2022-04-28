package com.ufra.edu.museu.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "especies")
public class Especies implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_cientifico;
    private String nome_comum;
    private String descricao;
    private String curiosidades;

    public Especies(){

    }

    public Especies(Long id, String nome_cientifico, String nome_comum, String descricao, String curiosidades) {
        this.id = id;
        this.nome_cientifico = nome_cientifico;
        this.nome_comum = nome_comum;
        this.descricao = descricao;
        this.curiosidades = curiosidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_cientifico() {
        return nome_cientifico;
    }

    public void setNome_cientifico(String nome_cientifico) {
        this.nome_cientifico = nome_cientifico;
    }

    public String getNome_comum() {
        return nome_comum;
    }

    public void setNome_comum(String nome_comum) {
        this.nome_comum = nome_comum;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCuriosidades() {
        return curiosidades;
    }

    public void setCuriosidades(String curiosidades) {
        this.curiosidades = curiosidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especies especies = (Especies) o;
        return id.equals(especies.id) && nome_cientifico.equals(especies.nome_cientifico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome_cientifico);
    }
}
