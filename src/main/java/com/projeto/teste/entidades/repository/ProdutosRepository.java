package com.projeto.teste.entidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entidades.Produtos;

public interface ProdutosRepository  extends JpaRepository<Produtos, Long> {

}
