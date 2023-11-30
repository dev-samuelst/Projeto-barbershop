package controllers;

import models.Corte;
import play.mvc.Controller;

public class Cortes extends Controller{
	public static void corte() {
		render();
	}

	public static void amostracorte() {
		render();
	}
	
	public static void add(Corte corte) {
		corte.save();
		corte();
	}

	public static void del(Long id) {
		Corte corte = Corte.findById(id);
		corte.delete();
		Users.list(null);
	}
}
