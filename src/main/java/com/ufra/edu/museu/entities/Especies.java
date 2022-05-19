package com.ufra.edu.museu.entities;


import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@CrossOrigin
@Entity
@Table(name = "especies")
public class Especies implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_cientifico;
    private String nome_comum;
    private String curiosidades;

    @ManyToOne
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;

    @ManyToOne
    @JoinColumn(name = "metamorfose_id")
    private Metamorfose metamorfose;

    @ManyToOne
    @JoinColumn(name = "comportamento_id")
    private Comportamento comportamento;

    @ManyToOne
    @JoinColumn(name = "pernas_id")
    private Pernas pernas;

    @ManyToOne
    @JoinColumn(name = "asas_id")
    private Asas asas;

    @ManyToOne
    @JoinColumn(name = "abdomen_id")
    private Abdomen abdomen;

    @ManyToOne
    @JoinColumn(name = "aparelho_bucal_id")
    private Aparelho_bucal aparelho_bucal;

    @ManyToOne
    @JoinColumn(name = "antenas_id")
    private Antenas antenas;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "familia_id")
    private Familia familia;

    @ManyToOne
    @JoinColumn(name = "ordem_id")
    private Ordem ordem;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "filo_id")
    private Filo filo;

    public Especies(){

    }

    public Especies(Long id, String nome_cientifico, String nome_comum, String curiosidades, Habitat habitat, Metamorfose metamorfose, Comportamento comportamento, Pernas pernas, Asas asas, Abdomen abdomen, Aparelho_bucal aparelho_bucal, Antenas antenas, Genero genero, Familia familia, Ordem ordem, Classe classe, Filo filo) {
        this.id = id;
        this.nome_cientifico = nome_cientifico;
        this.nome_comum = nome_comum;
        this.curiosidades = curiosidades;
        this.habitat = habitat;
        this.metamorfose = metamorfose;
        this.comportamento = comportamento;
        this.pernas = pernas;
        this.asas = asas;
        this.abdomen = abdomen;
        this.aparelho_bucal = aparelho_bucal;
        this.antenas = antenas;
        this.genero = genero;
        this.familia = familia;
        this.ordem = ordem;
        this.classe = classe;
        this.filo = filo;
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

    public String getCuriosidades() {
        return curiosidades;
    }

    public void setCuriosidades(String curiosidades) {
        this.curiosidades = curiosidades;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Metamorfose getMetamorfose() {
        return metamorfose;
    }

    public void setMetamorfose(Metamorfose metamorfose) {
        this.metamorfose = metamorfose;
    }

    public Comportamento getComportamento() {
        return comportamento;
    }

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    public Pernas getPernas() {
        return pernas;
    }

    public void setPernas(Pernas pernas) {
        this.pernas = pernas;
    }

    public Asas getAsas() {
        return asas;
    }

    public void setAsas(Asas asas) {
        this.asas = asas;
    }

    public Abdomen getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(Abdomen abdomen) {
        this.abdomen = abdomen;
    }

    public Aparelho_bucal getAparelho_bucal() {
        return aparelho_bucal;
    }

    public void setAparelho_bucal(Aparelho_bucal aparelho_bucal) {
        this.aparelho_bucal = aparelho_bucal;
    }

    public Antenas getAntenas() {
        return antenas;
    }

    public void setAntenas(Antenas antenas) {
        this.antenas = antenas;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Filo getFilo() {
        return filo;
    }

    public void setFilo(Filo filo) {
        this.filo = filo;
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
