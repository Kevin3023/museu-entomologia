package com.ufra.edu.museu.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "asas")
public class Asas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome_asa;

	public Asas() {
	}

	public Asas(Long id, String nome_asa) {
		this.id = id;
		this.nome_asa = nome_asa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_asa() {
		return nome_asa;
	}

	public void setNome_asa(String nome_asa) {
		this.nome_asa = nome_asa;
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
		Asas other = (Asas) obj;
		return Objects.equals(id, other.id);
	}
}
