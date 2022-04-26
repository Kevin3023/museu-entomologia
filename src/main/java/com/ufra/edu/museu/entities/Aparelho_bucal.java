package com.ufra.edu.museu.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "aparelho_bucal")
public class Aparelho_bucal implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public Aparelho_bucal(){

    }

    public Aparelho_bucal(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
        Aparelho_bucal other = (Aparelho_bucal) obj;
        return Objects.equals(id, other.id);
    }
}
