package aula06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static final String USUARIO = "usuario";

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
		
		String nomeUsuario = request.getParameter(USUARIO);
		String senhaUsuario = request.getParameter("senha");
		
		if (autenticar(nomeUsuario,senhaUsuario)) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute(USUARIO, nomeUsuario);
//			resposta.write("Bem vindo "+ nomeUsuario);
			
			request.getRequestDispatcher("ServletMenu").forward(request, response);
			
		} else {
			resposta.write("Usu�rio e senha inv�lidos");
		}
		resposta.write("</body></html>");
	}

	private boolean autenticar(String nomeUsuario, String senhaUsuario) {
		// Aqui vai o c�digo de autentica��o do usu�rio
		// Aqui os acessos ao banco de dados ser�o feitos para validar o usu�rio
		
		// Regra: Usu�rio deve ser preenchido e a senha deve ser 1234
		if (nomeUsuario != null && !nomeUsuario.equals("") && senhaUsuario != null && !senhaUsuario.equals("") && senhaUsuario.equals("1234")) {
			return true;
		}
		
		return false;
	}

}
