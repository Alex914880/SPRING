package it.exolab.musica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exolab.musica.model.Album;
import it.exolab.musica.repository.AlbumRepository;

@Service
public class AlbumService 
{
	@Autowired
	private AlbumRepository albumRepository;
	
	public Album findAlbumByTitolo(String titolo)
	{
		return albumRepository.findAlbumByTitolo(titolo);
	}
}
