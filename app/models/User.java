package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class User extends Model{
	
	@Required
	public String name;
	@Required
	public String email;
	@Required
	@MinSize(6)
	public String password;
	
	@Required
	public String perfil;
	
	@ManyToOne
	@JoinColumn(name="idBarbeiro")
	public Barbeiro barbeiro;

}
