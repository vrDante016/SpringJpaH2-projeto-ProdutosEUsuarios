package com.projeto.teste.entidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entidades.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long> {

}
