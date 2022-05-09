package com.ufra.edu.museu.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "pernas")
public class Pernas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome_perna;

	@JsonIgnore
	@OneToMany(mappedBy = "pernas")
	private List<Especies> especies = new ArrayList<>();

	public Pernas() {
	}

	public Pernas(Long id, String nome_perna) {
		this.id = id;
		this.nome_perna = nome_perna;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_perna() {
		return nome_perna;
	}

	public void setNome_perna(String nome_perna) {
		this.nome_perna = nome_perna;
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
		Pernas other = (Pernas) obj;
		return Objects.equals(id, other.id);
	}
}
