package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity

public class Barbeiro extends Model {
	
	public String nome;
	public String cpf;
	public String email;
	public String telefone;
	public String password;

}
