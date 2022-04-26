package com.ufra.edu.museu.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "comportamento")
public class Comportamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo_comportamento;

    public Comportamento(){

    }

    public Comportamento(Long id, String tipo_comportamento) {
        this.id = id;
        this.tipo_comportamento = tipo_comportamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_comportamento() {
        return tipo_comportamento;
    }

    public void setTipo_comportamento(String tipo_comportamento) {
        this.tipo_comportamento = tipo_comportamento;
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
        Comportamento other = (Comportamento) obj;
        return Objects.equals(id, other.id);
    }
}
