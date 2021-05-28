package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.UsuarioDaoImpl;
import br.com.bank.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioDaoImpl dao;
	
	public UsuarioServiceImpl() {
		this.dao = new UsuarioDaoImpl();
	}
	
	@Override
	public List<Usuario> list() {
		return this.dao.list();
	}

	@Override
	public void save(Usuario usuario) {
		this.dao.save(usuario);
	}

	@Override
	public void deletar(Long idUsuario) {
		this.dao.deletar(idUsuario);
	}

	@Override
	public Usuario findById(Long id) {
		return this.dao.findById(id);
	}

	@Override
	public void edit(Usuario usuario) {
		this.dao.edit(usuario);
	}

}
