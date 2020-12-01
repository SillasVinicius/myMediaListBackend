package com.sd.myMediaList.Repositiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.myMediaList.Models.Tipo;

public interface TipoRepositoryJPA extends JpaRepository<Tipo, Long>{

	Tipo findByDescricao(String descricao);

}
