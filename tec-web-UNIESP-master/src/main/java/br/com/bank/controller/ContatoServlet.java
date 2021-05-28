package br.com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Contato;
import br.com.bank.service.ContatoService;
import br.com.bank.service.ContatoServiceImpl;

/**
 * Servlet implementation class ContatoServlet
 */

@WebServlet("/contatosServlet")
public class ContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private Contato contato;
	private ContatoService service;
	
	public ContatoServlet() {
		this.service = new ContatoServiceImpl();
		this.contato = new Contato();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		
		case "listar":
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
			request.setAttribute("contatos", this.service.list());
			rd.forward(request, response);
			break;
			
		case "remover":

			String id = request.getParameter("id");
			this.service.deletar(Long.parseLong(id));
			RequestDispatcher rd1 = request.getRequestDispatcher("/contatosServlet?acao=listar");
			request.setAttribute("remover", "Contato removido com sucesso");
			rd1.forward(request, response);
			break;
		
		case "getContato":
			
			Long id1 = Long.parseLong(request.getParameter("id"));
			Contato contato = service.findById(id1);
			
			RequestDispatcher rd2 = request.getRequestDispatcher("admin/pages/contatos/edit_contatos.jsp");
			request.setAttribute("contato", contato);
			rd2.forward(request, response);
			
			break;
			
		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
				
		switch (acao) {
		case "salvar":
			
			this.contato = new Contato();
			this.contato.setName(request.getParameter("nome"));
			this.contato.setContato(request.getParameter("contato"));
			this.contato.setEmail(request.getParameter("email"));
			
			this.service.salvar(contato);
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
			request.setAttribute("sucesso", "Contato " + contato.getName() + " salvo com sucesso.");
			request.setAttribute("contatos", this.service.list());
			rd.forward(request, response);
			break;		
		
		case "editar":
			
			long id = Long.parseLong(request.getParameter("id"));
			
			this.contato = this.service.findById(id);
			this.contato.setName(request.getParameter("nome"));
			this.contato.setContato(request.getParameter("contato"));
			this.contato.setEmail(request.getParameter("email"));
			
			this.service.edit(contato);
			
			RequestDispatcher rd1 = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
			request.setAttribute("sucesso", "Contato " + contato.getName() + " editada com sucesso.");
			request.setAttribute("contatos", this.service.list());
			rd1.forward(request, response);
			break;
			
		default:
			break;
		}
	}
}
