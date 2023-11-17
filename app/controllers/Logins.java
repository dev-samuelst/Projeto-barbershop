package controllers;

import models.User;
import play.mvc.Controller;

public class Logins extends Controller{
	
	public static void login() {
		render();
	}
	
public static void logar(String email, String password) {
		
		User pessoaBanco = User.find("email = ?1 and password = ?2", email, password).first();
		if (pessoaBanco != null) {
			session.put("usuarioLogado", pessoaBanco.name);
			session.put("perfilUser", pessoaBanco.perfil);
			flash.success("Login realizado com sucesso!");
			Users.list(null);
		}
		
		flash.error("Credenciais inválidas");
		login();
	}
	
	public static void logout() {
		session.clear();
		flash.success("Você saiu do sistema");
		login();
	}

}



