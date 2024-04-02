package it.exolab.musica.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="artista")
public class Artista implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_artista")
	private Integer idArtista;
	
	@Column(name = "nome_artistico")
	private String nomeArtistico;
	
	@Column(name="ascoltatori")
	private Integer ascoltatori;
	
	@Column(name="immagine")
	private String immagine;
	
	@OneToMany(mappedBy = "artista",  cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}	/*, DI DEFAULT IL FETCH= FetchType.LAZY*/)	
	private List<Album> listAlbum;
	
	public Artista(Integer idArtista, String nomeArtistico, Integer ascoltatori, String immagine) {
		super();
		this.idArtista = idArtista;
		this.nomeArtistico = nomeArtistico;
		this.ascoltatori = ascoltatori;
		this.immagine = immagine;
	}
	public Artista() {
	}
	public Artista(Integer idArtista) {
		super();
		this.idArtista = idArtista;
	}

	
	public List<Album> getListAlbum() {
		return listAlbum;
	}
	public void setListAlbum(List<Album> listAlbum) {
		this.listAlbum = listAlbum;
	}
	public Integer getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(Integer idArtista) {
		this.idArtista = idArtista;
	}
	public String getNomeArtistico() {
		return nomeArtistico;
	}
	public void setNomeArtistico(String nomeArtistico) {
		this.nomeArtistico = nomeArtistico;
	}
	public Integer getAscoltatori() {
		return ascoltatori;
	}
	public void setAscoltatori(Integer ascoltatori) {
		this.ascoltatori = ascoltatori;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	@Override
	public String toString() {
		return "[NOME= " + nomeArtistico + ", ASCOLTATORI= " + ascoltatori + ", IMMAGINE= " + immagine + " \n";
	}
	
}

