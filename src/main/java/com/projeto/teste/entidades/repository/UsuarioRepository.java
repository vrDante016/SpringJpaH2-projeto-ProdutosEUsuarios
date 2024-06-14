package com.projeto.teste.entidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.projeto.teste.entidades.Usuario;

@Service
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
