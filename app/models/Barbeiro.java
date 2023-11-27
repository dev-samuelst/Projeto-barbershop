package models;

import javax.persistence.Entity;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity

public class Barbeiro extends Model {
	
	@Required
	public String nome;
	@Required
	public String cpf;
	@Required
	public String email;
	public String telefone;
	@Required
	@MinSize(6)
	public String password;
	public String perfil;

}
