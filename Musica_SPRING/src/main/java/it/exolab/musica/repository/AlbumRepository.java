package it.exolab.musica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.exolab.musica.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> 
{
	public Album findAlbumByTitolo(String titolo);

}
