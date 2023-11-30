package controllers;

import models.Barbeiro;
import models.Corte;
import models.User;
import play.mvc.Controller;

public class Logins extends Controller {

	public static void login() {
		render();
	}

	public static void logar(String email, String password) {

		User pessoaBanco = User.find("email = ?1 and password = ?2", email, password).first();
		Barbeiro barbeiro = Barbeiro.find("email = ?1 and password = ?2", email, password).first();
		if (pessoaBanco != null) {
			session.put("usuarioLogado", pessoaBanco.name);
			flash.success("Login realizado com sucesso!");
			
		}else if(barbeiro != null) {
			session.put("usuarioLogado", barbeiro.nome);
			session.put("perfilUser", barbeiro.perfil);
			flash.success("Login realizado com sucesso!");
			Users.list(null);
			if(barbeiro.perfil.equalsIgnoreCase("ADM")) {
				Barbeiros.list(null);
			}else {
				Cortes.corte();
			}
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
