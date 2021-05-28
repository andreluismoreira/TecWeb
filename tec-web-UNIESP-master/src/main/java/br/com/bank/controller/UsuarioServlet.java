package br.com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Usuario;
import br.com.bank.service.UsuarioService;
import br.com.bank.service.UsuarioServiceImpl;

@WebServlet("/usuariosServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Usuario usuario;
	private UsuarioService service;
	
	public UsuarioServlet() {
		this.service = new UsuarioServiceImpl();
		this.usuario = new Usuario();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		switch (acao) {
		case "listar": 
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/usuarios/list_usuarios.jsp");
			request.setAttribute("usuarios", this.service.list());
			rd.forward(request, response);
			break;
			
		case "remover":

			String id = request.getParameter("id");
			this.service.deletar(Long.parseLong(id));
			RequestDispatcher rd1 = request.getRequestDispatcher("/usuariosServlet?acao=listar");
			request.setAttribute("remover", "Usuario " + usuario.getUsername() + " removido com sucesso");
			rd1.forward(request, response);
			break;
			
			
		case "getUsuario":
			
			Long id1 = Long.parseLong(request.getParameter("id"));
			Usuario usuario = service.findById(id1);
			
			RequestDispatcher rd2 = request.getRequestDispatcher("admin/pages/usuarios/edit_usuarios.jsp");
			request.setAttribute("usuario", usuario);
			rd2.forward(request, response);
			
			break;
		default:
			break;
		
		
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		List<Usuario> all = this.service.list();
		
		switch (acao) {
		case "salvar":
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String cfpassword = request.getParameter("cfpassword");
			boolean userCadastrado = false;
			
			for (Usuario usuario : all) {
				if (usuario.getUsername().equals(username)) {
					RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/usuarios/add_usuarios.jsp");
					request.setAttribute("error", "Usuario já cadastrado");
					rd.forward(request, response);
					userCadastrado = true;
					break;
				} 
			}
			
			if (password.equals(cfpassword)) {
				if (userCadastrado == false) {
					
					this.usuario = new Usuario();
					this.usuario.setUsername(username);
					this.usuario.setPassword(password);
					
					this.service.edit(usuario);
					
					RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/usuarios/list_usuarios.jsp");
					request.setAttribute("sucesso", "Usuario " + usuario.getUsername() + " salvo com sucesso.");
					request.setAttribute("usuarios", this.service.list());
					rd.forward(request, response);
				}	
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/usuarios/add_usuarios.jsp");
				request.setAttribute("error", "Senhas não correspondem");
				rd.forward(request, response);
				
			}
			
			
			break;
			
		case "editar": 
						
			username = request.getParameter("username");
			password = request.getParameter("password");
			cfpassword = request.getParameter("cfpassword");
			
			if (password.equals(cfpassword)) {
				
					long id = Long.parseLong(request.getParameter("id"));
					this.usuario = this.service.findById(id);
					System.out.println(this.usuario.getUsername());
					this.usuario.setUsername(username);
					this.usuario.setPassword(password);
					System.out.println(this.usuario.getUsername());

					this.service.edit(usuario);
					
					RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/usuarios/list_usuarios.jsp");
					request.setAttribute("sucesso", "Usuario " + usuario.getUsername() + " editado com sucesso.");
					request.setAttribute("usuarios", this.service.list());
					rd.forward(request, response);
				
			} else {
			
				RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/usuarios/list_usuarios.jsp");
				request.setAttribute("error", "Senhas não correspondem");
				request.setAttribute("usuarios", this.service.list());
				rd.forward(request, response);
				
			}			
			
			break;
		default:
			break;
		}
	}

}
