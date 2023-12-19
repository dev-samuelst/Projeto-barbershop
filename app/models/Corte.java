package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Corte extends Model {
   
	public String corte;
	public String barba;
	public String sobrancelha;
	public String freestyle;
	public Date data;
	public String horario;
	public String dia;
	
    @ManyToOne
	@JoinColumn(name="idUser")
	public User user;
	
}
