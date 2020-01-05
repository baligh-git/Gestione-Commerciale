package it.baligh.webapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "UTENTI")
public class Utenti  implements Serializable
{
	
	private static final long serialVersionUID = 2541430087580098163L;
	
    @Id
    @Column(name = "USERID")
	private String user;

	private String pwd;

	private String abilitato;
	
	@OneToOne
	@JoinColumn(name = "IDCLIENTI",referencedColumnName = "idClienti")
	private Clienti clienti;
	
	@OneToMany(mappedBy = "utenti",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	private Set<Profili> profili=new HashSet<>();

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAbilitato() {
		return abilitato;
	}

	public void setAbilitato(String abilitato) {
		this.abilitato = abilitato;
	}

	public Clienti getClienti() {
		return clienti;
	}

	public void setClienti(Clienti clienti) {
		this.clienti = clienti;
	}

	public Set<Profili> getProfili() {
		return profili;
	}

	public void setProfili(Set<Profili> profili) {
		this.profili = profili;
	}
	
	
	
}

