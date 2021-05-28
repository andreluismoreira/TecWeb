package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.Contato;
import br.com.bank.model.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> list();
	
	public void save(Usuario usuario);
	
	public void deletar(Long idUsuario);
	
	public Usuario findById(Long id);
	
	public void edit(Usuario usuario);
}
