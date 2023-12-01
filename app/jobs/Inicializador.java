package jobs;

import java.util.Date;

import models.Barbeiro;
import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {
	
	@Override
	public void doJob() throws Exception {
		if (User.count() == 0) {
			User joao = new User();
			joao.name = "Joao Silva";
			joao.email = "joaojj@gmail.com";
			joao.password = "12345";
			
			joao.save();
			
			
		}
		
		if(Barbeiro.count() == 0) {
			Barbeiro marcio = new Barbeiro();
			marcio.nome = "Marcio Fontes ";
			marcio.cpf = "123456789";
			marcio.email = "macinhosensacao@gmail.com";
			marcio.perfil = "adm";
			marcio.telefone = "(84) 99090-3030";
			marcio.password = "macio44";
			
			marcio.save();
		}
	}
	
	
	

}
