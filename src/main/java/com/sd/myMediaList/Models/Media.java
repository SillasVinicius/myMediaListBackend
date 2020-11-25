package com.sd.myMediaList.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "media")
public class Media extends RepresentationModel<Media> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private String titulo;
	
	@ManyToOne
	private Tipo tipo;
	
	@Column(nullable = true)
	private int qtd_episodios;
	
	@Column(nullable = true)
	private int minutagem;
	
	@Column(nullable = true)
	private int qtd_paginas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getQtd_episodios() {
		return qtd_episodios;
	}

	public void setQtd_episodios(int qtd_episodios) {
		this.qtd_episodios = qtd_episodios;
	}

	public int getMinutagem() {
		return minutagem;
	}

	public void setMinutagem(int minutagem) {
		this.minutagem = minutagem;
	}

	public int getQtd_paginas() {
		return qtd_paginas;
	}

	public void setQtd_paginas(int qtd_paginas) {
		this.qtd_paginas = qtd_paginas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", titulo=" + titulo + ", tipo=" + tipo + ", qtd_episodios=" + qtd_episodios
				+ ", minutagem=" + minutagem + ", qtd_paginas=" + qtd_paginas + "]";
	}
	
}
