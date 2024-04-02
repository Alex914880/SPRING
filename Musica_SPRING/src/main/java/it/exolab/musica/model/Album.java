package it.exolab.musica.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "album")
public class Album implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_album")
	private Integer idAlbum;
	
	@Column(name="titolo")
	private String titolo;
	
	@Column(name="immagine")
	private String immagine;
	
	@Column(name="data_rilascio")
	private Date dataRilascio;
	
//	@Column(name="id_artista")
//	private Integer idArtista;
//	
	@ManyToOne ( cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH} )
	@JoinColumn(name = "id_artista", nullable = true, insertable = true, updatable = true)
	@JsonIgnore
	private Artista artista;
	
	
	@OneToMany(mappedBy = "album")
	private List<Canzone> canzoni;
	
	
	
	public Album(Integer idAlbum) {
		super();
		this.idAlbum = idAlbum;
	}

	public Album() {
		super();
	}

	public Album(Integer idAlbum, String titolo, String immagine, Date dataRilascio, Artista artista) {
		super();
		this.idAlbum = idAlbum;
		this.titolo = titolo;
		this.immagine = immagine;
		this.dataRilascio = dataRilascio;
		this.artista = artista;
	}
	
	
//	public Integer getIdArtista() {
//		return idArtista;
//	}
//	
//	public void setIdArtista(Integer idArtista) {
//		this.idArtista = idArtista;
//	}
	
	public Integer getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}
	public List<Canzone> getCanzoni() {
		return canzoni;
	}

	public void setCanzoni(List<Canzone> canzoni) {
		this.canzoni = canzoni;
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public Date getDataRilascio() {
		return dataRilascio;
	}
	public void setDataRilascio(Date dataRilascio) {
		this.dataRilascio = dataRilascio;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() 
	{
		return "[TITOLO= " + titolo  + ", IMMAGINE= " + immagine + ", DATA= "+ dataRilascio + ", Canzoni presenti nell'album= " + canzoni + "]\n";
	}
	

	
}
