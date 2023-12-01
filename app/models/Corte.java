package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Corte extends Model {
    @Required
	public String corte;
    @Required
	public String barba;
    @Required
	public String sobrancelha;
    @Required
	public String freestyle;
    @Required
	public String horario;
    @Required
	public String dia;
	
	@OneToMany
	@JoinColumn(name="idCorte")
	public List<User> user;
	
}
