package it.exolab.musica.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.exolab.musica.model.Artista;
import it.exolab.musica.service.ArtistaService;

@RestController
@RequestMapping(path="/artista")
@CrossOrigin
public class ArtistaRest 
{
	@Autowired
	private ArtistaService artistaService;
	
	@GetMapping(path= "/findAllArtisti")
	public ResponseEntity<List<Artista>> findAll()
	{
		System.out.println("NEL METODO FINDALL DI ARTISTA");
		try
		{
			return ResponseEntity.ok(artistaService.findAll());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> insert(@RequestBody Artista artista)
	{
		System.out.println("DENTRO INSERT ARTISTA");
		try
		{
			Artista artistaDaRestituire = artistaService.insert(artista);
			return ResponseEntity.ok(artistaDaRestituire);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return  ResponseEntity.internalServerError().build();
		}
		
	}

	@GetMapping(path="/findArtista/{nomeArtistico}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> findArtistaByNomeArtistico(@PathVariable("nomeArtistico") String nomeArtistico)
	{
		try
		{
			return ResponseEntity.ok(artistaService.findByNomeArtistico(nomeArtistico));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}
