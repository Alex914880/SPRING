package it.exolab.musica.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.exolab.musica.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>
{
	
	public Artista findArtistaByNomeArtistico(String nomeArtistico);

}
