package it.exolab.musica.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="genere")
public class Genere 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genere")
	private Integer idGenere;

	@Column
	private String genere;
	
	@ManyToMany(mappedBy = "generi")
	@JsonIgnore
	private List<Canzone> canzoni;

	public Integer getIdGenere() {
		return idGenere;
	}

	public void setIdGenere(Integer idGenere) {
		this.idGenere = idGenere;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	
	public List<Canzone> getCanzoni() {
		return canzoni;
	}

	public void setCanzoni(List<Canzone> canzoni) {
		this.canzoni = canzoni;
	}
	

}
