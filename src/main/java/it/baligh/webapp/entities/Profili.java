package it.baligh.webapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROFILI")
public class Profili  implements Serializable
{
	
	private static final long serialVersionUID = -5363946195612668216L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDPROFILI")
	private long idProfili;
	
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "USERID",referencedColumnName = "USERID")
	private Utenti utenti;
	
	

	public Profili() {
		super();
	}

	public Profili(String tipo, Utenti utenti) {
		super();
		this.tipo = tipo;
		this.utenti = utenti;
	}

	public long getIdProfili() {
		return idProfili;
	}

	public void setIdProfili(long idProfili) {
		this.idProfili = idProfili;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Utenti getUtenti() {
		return utenti;
	}

	public void setUtenti(Utenti utenti) {
		this.utenti = utenti;
	}
	 
	
	
	

}
