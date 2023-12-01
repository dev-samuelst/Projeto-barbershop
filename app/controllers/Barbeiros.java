package controllers;

import java.util.List;

import anotacions.Administrador;
import models.Barbeiro;
import models.Corte;
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
		list(null);
	}
	
	@Administrador
	public static void del(Long id) {
		Barbeiro barber = Barbeiro.findById(id);
		if(barber.perfil.equalsIgnoreCase("adm")) {
			Logins.logout();
		}
		barber.delete();
		list(null);
	}
	
	public static void list(String termo) {
		List<Barbeiro> barbers = null;
		if(termo == null || termo.isEmpty()) {
			barbers = Barbeiro.findAll();
		}else {
			barbers = Barbeiro.find("lower(nome) like ?1 or lower(email) like ?1",
					"%"+ termo.toLowerCase() +"%").fetch();
		}
		render(barbers);
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
	
	public static void agenda() {
		List<Corte> cortes = Corte.findAll();
		render(cortes);
	}
	
	public static void delCorte(Long id) {
		Corte corte = Corte.findById(id);
		corte.delete();
		agenda();
	}

}
