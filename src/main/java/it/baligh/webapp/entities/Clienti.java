package it.baligh.webapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLIENTI")
public class Clienti  implements Serializable
{
	private static final long serialVersionUID = -6994272792307526864L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDCLIENTI")
	private long idClienti;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "COGNOME")
	private String cognome;
	
	@Column(name = "PROV")
	private String prov;
	
	@Column(name = "COMUNE")
	private String comune;
	
	@Column(name = "INDIRIZZO")
	private String indirizzo;

	@Column(name = "MAIL")
	private String mail;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATACREAZIONE")
	private Date dataCreaz;
	
	@OneToOne(mappedBy = "clienti",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	private Utenti utenti;

	public long getIdClienti() {
		return idClienti;
	}

	public void setIdClienti(long idClienti) {
		this.idClienti = idClienti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDataCreaz() {
		return dataCreaz;
	}

	public void setDataCreaz(Date dataCreaz) {
		this.dataCreaz = dataCreaz;
	}

	public Utenti getUtenti() {
		return utenti;
	}

	public void setUtenti(Utenti utenti) {
		this.utenti = utenti;
	}
	
	
	
}
