package com.projeto.teste.entidades.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.teste.entidades.Usuario;
import com.projeto.teste.services.UsuarioServicos;

@RestController
@RequestMapping(value = "/user")
public class UsuarioResource {
	
	@Autowired
	private UsuarioServicos usuarioServicos;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findall(){
		List<Usuario> list = usuarioServicos.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario usuario2 = usuarioServicos.findByid(id);
		return ResponseEntity.ok().body(usuario2);
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		usuarioServicos.deleteById(id);
	}
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario){
		Usuario novoUsuario = usuarioServicos.insert(usuario);
		return ResponseEntity.ok().body(novoUsuario);
	}
}
