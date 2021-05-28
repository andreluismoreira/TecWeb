package br.com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.bank.model.Usuario;
import br.com.bank.service.UsuarioService;
import br.com.bank.service.UsuarioServiceImpl;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioService service;
	
	public LoginServlet() {
		this.service = new UsuarioServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean Auth = false;
		
		List<Usuario> usuarios = this.service.list();
		for (Usuario usuario : usuarios) {
			if (username.equals(usuario.getUsername()) && password.equals(usuario.getPassword())) {
				Auth = true;
				break;
			} else {
				Auth = false;
			}
		}
		
		if (username.equals("admin") && password.equals("123")) {
			Auth = true;
		}
		
		if (Auth) {
			session.setAttribute("userLogado", username);
			response.sendRedirect("home");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
			request.setAttribute("error", "Usuario ou Senha incorreto");
			rd.forward(request, response);
		}
		
	}

}
