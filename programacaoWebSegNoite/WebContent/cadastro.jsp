<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dados Pessoais</title>
</head>
<body>
Preencha os seus dados pessoais:
	<form action="ServletTela1Cadastro">
		Nome: <input type="text" name="nome">
		Sobrenome: <input type="text" name="sobrenome"><br>
		Endere�o residencial:<br>
		Rua: <input type="text" name="rua">
		Complemento: <input type="text" name="complemento"><br>
		Cidade: <input type="text" name="cidade">
		CEP: <input type="text" name="cep">
		Estado: <input type="text" name="estado"><br>
		<input type="submit" value="Pr�xima tela"><br>
	</form>
</body>
</html>