package com.ufra.edu.museu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "habitat")
public class Habitat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo_habitat;

    @JsonIgnore
    @OneToMany(mappedBy = "habitat")
    private List<Especies> especies = new ArrayList<>();

    public Habitat(){

    }

    public Habitat(Long id, String tipo_habitat) {
        this.id = id;
        this.tipo_habitat = tipo_habitat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_habitat() {
        return tipo_habitat;
    }

    public void setTipo_habitat(String tipo_habitat) {
        this.tipo_habitat = tipo_habitat;
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
        Habitat other = (Habitat) obj;
        return Objects.equals(id, other.id);
    }
}
