package controllers;

import java.util.List;

import models.Barbeiro;
import models.Corte;
import models.User;
import play.mvc.Controller;

public class Cortes extends Controller{
	public static void corte() {
		render();
	}

	public static void amostracorte() {
		render();
	}
	
	public static void add(Corte corte) {
		
		
		List<Corte> cortes = Corte.findAll();
		for (Corte corte2 : cortes) {
			if(corte.horario.equals(corte2.horario) && corte.user.barbeiro.id.equals(corte2.user.barbeiro.id)) {
				flash.error("Horario já Cadastrado, por favor escolha outro");
				renderTemplate("Cortes/corte.html", corte);
			}
		}
		
		corte.save();
		flash.success("Agendado com sucesso");
		list(corte.user.id);
		
	}

	public static void del(Long id) {
		Corte corte = Corte.findById(id);
		corte.delete();
		corte();
	}
	
	
	public static void detalhar(Long id) {
		Corte c = Corte.findById(id);
		render(c);
	}
	
	public static void list(Long id) {
		List<Corte> cortes = Corte.find("(corte.user.id) like ?1",id).fetch();
		
		render(cortes);
	}
}
