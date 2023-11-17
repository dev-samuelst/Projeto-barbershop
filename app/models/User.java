package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class User extends Model{
	
	public String name;
	public String email;
	public String password;
	public String perfil;
	
	
	@ManyToOne
	@JoinColumn(name="idBarbeiro")
	public Barbeiro barbeiro;

}
