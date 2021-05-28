package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.ContatoDaoImpl;
import br.com.bank.model.Contato;

public class ContatoServiceImpl implements ContatoService{
	
	private ContatoDaoImpl dao;
	
	public ContatoServiceImpl() {
		this.dao = new ContatoDaoImpl();
	}
	

	@Override
	public Contato findById(Long id) {
		return this.dao.findById(id);
	}
	
	@Override
	public void salvar(Contato contato) {
		this.dao.salvar(contato);
	}

	@Override
	public List<Contato> list() {
		return this.dao.list();
	}

	@Override
	public void deletar(Long idContato) {
		this.dao.deletar(idContato);
		
	}

	@Override
	public Contato getContato(String name) {
		return this.dao.getContato(name);
	}


	@Override
	public void edit(Contato contato) {
		this.dao.edit(contato);
	}


}
