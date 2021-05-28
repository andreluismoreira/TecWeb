package br.com.bank.service;

import java.util.List;

import br.com.bank.model.Usuario;

public interface UsuarioService {
	
	public List<Usuario> list();
	
	public void save(Usuario usuario);
	
	public void deletar(Long idUsuario);
	
	public Usuario findById(Long id);
	
	public void edit(Usuario usuario);
}
