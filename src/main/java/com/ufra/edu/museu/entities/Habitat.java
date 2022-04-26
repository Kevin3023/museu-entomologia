package com.ufra.edu.museu.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "habitat")
public class Habitat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipo_habitat;

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
