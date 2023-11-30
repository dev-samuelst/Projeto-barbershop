package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Corte extends Model {
	public String corte;
	public String barba;
	public String sobrancelha;
	public String freestyle;
	public String horario;
}
