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
 * Servlet implementation class ServletTela2CadastroSessao
 */
@WebServlet("/ServletTela2CadastroSessao")
public class ServletTela2CadastroSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTela2CadastroSessao() {
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
		resposta.write("<html>");
		resposta.write("<head>");
		resposta.write("<title>Confirmação de registro</title>");
		resposta.write("</head>");
		resposta.write("<body>");
		
		HttpSession sessao = request.getSession(false);
		
		if (sessao == null || sessao.getAttribute(ServletLogin.USUARIO) == null) {
			resposta.write("<a href=\"login.jsp\">Faça primeiro o login na aplicação.</a>");
		} else {
			resposta.write("<h3>Registro realizado com sucesso!</h3><br/><br/>");
			resposta.write("<b>Seus dados pessoais:</b><br/>");
			
			DadosPessoais dados = (DadosPessoais) sessao.getAttribute("dadosPessoais");
			
			if (dados == null) {
				resposta.write("<a href=\"login.jsp\">Dados incompletos. Inicie o sistema novamente.</a>");
			} else {
				resposta.write(dados.getNome() + " " + dados.getSobrenome());
				resposta.write("<BR>");
                resposta.write(dados.getRua());
                resposta.write("<BR>");
                resposta.write(dados.getComplemento());
                resposta.write("<BR>");
                resposta.write(dados.getCidade());
                resposta.write(", ");
                resposta.write(dados.getCep());
                resposta.write(", ");
                resposta.write(dados.getEstado());
				resposta.write("<br/>");
				resposta.write("<b>Seus dados profissionais:</b><br/>");
				resposta.write(request.getParameter("empresa"));
				resposta.write("<br/>");
				resposta.write(request.getParameter("ruaEmpresa"));
				resposta.write("<br/>");
				resposta.write(request.getParameter("complementoEmpresa"));
				resposta.write("<br/>");
				resposta.write(request.getParameter("cidadeEmpresa"));
				resposta.write(", ");
				resposta.write(request.getParameter("cepEmpresa"));
				resposta.write(", ");
				resposta.write(request.getParameter("estadoEmpresa"));
			}
		}
		
		resposta.write("</body></html>");
	}

}
