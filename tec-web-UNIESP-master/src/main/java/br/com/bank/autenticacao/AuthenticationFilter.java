package br.com.bank.autenticacao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		boolean logado = (session != null && session.getAttribute("userLogado") != null);
		
		String urlLogin = httpRequest.getContextPath() + "/loginServlet";
		
		boolean requestLogin = httpRequest.getRequestURI().equals(urlLogin);
		
		boolean paginaLogin = httpRequest.getRequestURI().endsWith("login");
		
		
		if (logado || paginaLogin || requestLogin) {
			chain.doFilter(httpRequest, httpResponse);
			return;
		} else {
			httpResponse.sendRedirect("login");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}
}
