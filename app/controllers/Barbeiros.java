package controllers;

import java.util.Collections;
import java.util.List;

import anotacions.Administrador;
import models.Barbeiro;
import models.Corte;
import models.User;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Barbeiros extends Controller {
	
	public static void add(@Valid Barbeiro barber) {
		if(validation.hasErrors()) {
			redirecionarErros();
		}
		barber.save();
		list();
	}
	
	@Administrador
	public static void del(Long id) {
		Barbeiro barber = Barbeiro.findById(id);
		if(barber.perfil.equalsIgnoreCase("adm")) {
			Logins.logout();
		}
		barber.delete();
		list();
	}
	
	public static void list() {
		render();
	}
	
	public static void listAjax(String termo) {
		List<Barbeiro> barbers = Collections.emptyList();
		if (termo == null || termo.trim().isEmpty()) {
			barbers = Barbeiro.findAll();
		} else {
			barbers = Barbeiro.find("nome like ?1 or email like ?1", "%"+termo+"%").fetch();
		}
		renderJSON(barbers);
	}
	
	public static void edit(Long id) {
		Barbeiro barber = Barbeiro.findById(id);
		renderTemplate("Barbeiros/form.html", barber);
		
	}
	
	public static void form() {
		render();
		
	}
	
	private static void redirecionarErros() {
		params.flash();
		validation.keep();
		form();
	}
	
	public static void agenda(Long id) {
		List<Corte> cortes = Corte.find("(corte.user.barbeiro.id) like ?1",id).fetch();
		render(cortes);
	}
	
	public static void delCorte(Long id) {
		Corte corte = Corte.findById(id);
		corte.delete();
		agenda(corte.user.barbeiro.id);
	}

}
