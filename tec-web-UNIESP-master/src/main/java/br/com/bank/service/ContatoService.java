package br.com.bank.service;

import java.util.List;

import br.com.bank.model.Contato;

public interface ContatoService {
	
	public Contato getContato(String name);
	
	public void salvar(Contato contato);
	
	public List<Contato> list();
	
	public void deletar(Long idContato);
	
	public Contato findById(Long id);
	
	public void edit(Contato contato);
}
