package it.exolab.musica.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "canzone")
public class Canzone implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_canzone")
	private Integer idCanzone;
	
	@Column(name="titolo")
	private String titolo;
	
	@Column(name = "durata_minuti")
	private Float durata;
	
//	@Column(name="id_album")
//	private Integer idAlbum;
	
	@ManyToOne ( cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH } )
	@JoinColumn(name = "id_album", nullable = true, insertable = true, updatable = false)
	@JsonIgnore
	private Album album;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH })
	
	@JoinTable( name = "genere_canzone", 
				joinColumns = @JoinColumn(name = "id_canzone", referencedColumnName = "id_canzone"), 
				inverseJoinColumns = @JoinColumn(name = "id_genere", referencedColumnName = "id_genere"))
	private List<Genere> generi;
	
	
	public List<Genere> getGeneri() {
		return generi;
	}
	public void setGeneri(List<Genere> generi) {
		this.generi = generi;
	}
	public Canzone() {
	}
	public Canzone(Album album) {
		this.album = album;
	}
	public Canzone(Album album, Integer idCanzone, String titolo, Float durata) {
		this.album = album;
		this.idCanzone = idCanzone;
		this.titolo = titolo;
		this.durata = durata;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Integer getIdCanzone() {
		return idCanzone;
	}
	public void setIdCanzone(Integer idCanzone) {
		this.idCanzone = idCanzone;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Float getDurata() {
		return durata;
	}
	public void setDurata(Float durata) {
		this.durata = durata;
	}
	
//	public Integer getIdAlbum() {
//		return idAlbum;
//	}
//	public void setIdAlbum(Integer idAlbum) {
//		this.idAlbum = idAlbum;
//	}
	
	@Override
	public String toString() {
		return "[TITOLO= " + titolo + ", DURATA= " + durata
				+ "]\n";
	}


}
