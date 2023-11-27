package controllers;

import java.util.List;

import anotacions.Administrador;
import models.Barbeiro;
import models.User;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Users extends Controller{

	public static void add(@Valid User user) {
		if(validation.hasErrors()) {
			redirecionarErros();
		}
		user.save();
		list(null);
	}
	
	@Administrador
	public static void del(Long id) {
		User user = User.findById(id);
		user.delete();
		list(null);
	}
	
	public static void list(String termo) {
		List<User> users = null;
		if(termo == null || termo.isEmpty()) {
			users = User.findAll();	
		}else{
			users = User.find("lower(name) like ?1 or lower(email) like ?1",
					"%"+ termo.toLowerCase() +"%").fetch();
		}
		
		render(users);
	}
	
	public static void edit(Long id) {
		User user = User.findById(id);
		List<Barbeiro> barbeiros = Barbeiro.findAll();
		renderTemplate("Users/form.html", user, barbeiros);
		
	}
	
	public static void form() {
		List<Barbeiro> barbeiros = Barbeiro.findAll();
		render(barbeiros);
		
	}
	public static void login() {
		render();
	}
	
	private static void redirecionarErros() {
		params.flash();
		validation.keep();
		form();
	}

}
