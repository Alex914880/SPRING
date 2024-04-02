package it.exolab.musica.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.exolab.musica.model.Album;
import it.exolab.musica.service.AlbumService;

@RestController
@CrossOrigin
@RequestMapping(path = "/album")
public class AlbumRest 
{
	@Autowired
	private AlbumService albumservice;
	
	@GetMapping("/find/{titolo}")
	public ResponseEntity<Album> findAlbumByTitolo(@PathVariable("titolo") String titolo)
	{
		try
		{
			return ResponseEntity.ok( albumservice.findAlbumByTitolo(titolo));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

}
