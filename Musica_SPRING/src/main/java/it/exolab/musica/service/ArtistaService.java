package it.exolab.musica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exolab.musica.model.Artista;
import it.exolab.musica.repository.ArtistaRepository;

@Service
public class ArtistaService 
{
	@Autowired		
	//Fa la Dependency Injection, sostituisce @Inject
	private ArtistaRepository artistaRepository;
	
	public List<Artista> findAll()
	{
		return artistaRepository.findAll();
	}

	public Artista insert(Artista artista)
	{
		artistaRepository.save(artista);
		return artista;
	}
	
	public Artista findByNomeArtistico(String nomeArtistico)
	{
		return artistaRepository.findArtistaByNomeArtistico(nomeArtistico);
	}
}
