package controllers;

import java.util.List;

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
		
		/*String[] hora = {"8:00", "9:00", "10:00", "11:00", 
				"13:00", "14:00", "15:00", "16:00", "17:00",
				"19:00", "20:00", "21:00",};*/
		List<Corte> cortes = Corte.findAll();
		
		for (int i = 0; i < cortes.size(); i++) {
			if(corte.horario.equals(cortes.get(i).horario)) {
				flash.error("Horario já Cadastrado, por favor escolha outro");
			}
		}
		
		corte.save();
		flash.success("Agendado com sucesso");
		corte();
	}

	public static void del(Long id) {
		Corte corte = Corte.findById(id);
		corte.delete();
		Users.list(null);
	}
}
