package aula07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aula06.ServletLogin;

/**
 * Servlet implementation class ServletMenu
 */
@WebServlet("/ServletMenu")
public class ServletMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter resposta = response.getWriter();
		
		resposta.write("<html><body>");
		
		HttpSession sessao = request.getSession(false);
		
		if (sessao == null || sessao.getAttribute(ServletLogin.USUARIO) == null) {
			resposta.write("<a href=\"login.jsp\">Fa�a primeiro o login na aplica��o.</a>");
		} else {
			resposta.write("<b>Opera��es dispon�veis</b><br>");
			resposta.write("<a href=\"cadastro.jsp\">1. Cadastro</a>");
			// Novas op��es de funcionalidades.
		}
		
		resposta.write("</body><html>");
	}
	

}
