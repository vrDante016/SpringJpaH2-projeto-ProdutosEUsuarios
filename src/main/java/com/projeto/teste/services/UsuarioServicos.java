package com.projeto.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.teste.entidades.Usuario;
import com.projeto.teste.entidades.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServicos {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	 
	public Usuario findByid(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	@Transactional
	public void deleteById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			usuarioRepository.deleteById(id);
		}
		
	}
	@Transactional
	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
