package com.ufra.edu.museu.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "abdomen")
public class Abdomen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome_abdomen;

    public Abdomen(){

    }

    public Abdomen(Integer id, String nome_abdomen) {
        this.id = id;
        this.nome_abdomen = nome_abdomen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_abdomen() {
        return nome_abdomen;
    }

    public void setNome_abdomen(String nome_abdomen) {
        this.nome_abdomen = nome_abdomen;
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
