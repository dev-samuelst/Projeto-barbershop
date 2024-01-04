package controllers;

import java.util.Collections;
import java.util.List;

import anotacions.Administrador;
import models.Barbeiro;
import models.User;
import net.bytebuddy.asm.Advice.This;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;


public class Users extends Controller{

	public static void add(@Valid User user) {
		if(validation.hasErrors()) {
			redirecionarErros();
		}
		user.save();
		flash.success("Cagastro feito com sucesso");
		form();
	}
	
	@Administrador
	public static void del(Long id) {
		User user = User.findById(id);
		user.delete();
		list();
	}
	
	public static void list() {
		render();
	}
	
	public static void listAjax(String termo) {
			List<User> users = Collections.emptyList();
			if (termo == null || termo.trim().isEmpty()) {
				users = User.findAll();
			} else {
				users = User.find("name like ?1 or email like ?1", "%"+termo+"%").fetch();
			}
			renderJSON(users);
		}
	
	public static void edit(Long id) {
		User user = User.findById(id);
		flash.put("user.id", user.id);
		flash.put("user.name", user.name);
		flash.put("user.email", user.email);
		flash.put("user.password", user.password);
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
