package controllers;

import java.util.List;

import models.Barbeiro;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Barbeiros extends Controller {
	
	public static void add(Barbeiro barber) {
		barber.save();
		list(null);
	}
	
	public static void del(Long id) {
		Barbeiro barber = Barbeiro.findById(id);
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

}
