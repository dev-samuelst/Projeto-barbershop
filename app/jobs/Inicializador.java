package jobs;

import java.util.Date;


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
	}

}
