package com.libertymutual.goforcode.wimp.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.services.ActorRepo;
import com.libertymutual.goforcode.wimp.services.MovieRepo;

@RestController
@RequestMapping("/api/movies")

public class MovieApiController {

	private MovieRepo movieRepo;
	private ActorRepo actorRepo;

//	public MovieApiController(MovieRepo movieRepo, ActorRepo actorRepo) {
//		this.movieRepo = movieRepo;
//		Movie movie = new Movie();
//		movie.setTitle("movieTitle1");
//		movie.setActors(actorRepo.findAll());
//		movieRepo.save(movie);
//		
//	}
	
	public MovieApiController(MovieRepo movieRepo, ActorRepo actorRepo) {
		this.movieRepo = movieRepo;
		this.actorRepo = actorRepo;
	}
	
	@GetMapping("")
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}

	@GetMapping("{id}")
	public Movie getOne(@PathVariable long id) throws StuffNotFoundException {
		Movie movie = movieRepo.findOne(id);
		if (movie == null) {
			throw new StuffNotFoundException();
		}
		return movie;
	}

	@PostMapping("")
	public Movie create(@RequestBody Movie movie) {
		return movieRepo.save(movie);
	}

	@PutMapping("{id}")
	public Movie update(@RequestBody Movie movie, @PathVariable long id) {
		movie.setId(id);
		return movieRepo.save(movie);
	}

	@DeleteMapping("{id}")
	public Movie delete(@PathVariable long id) {
		try {
			Movie movie = movieRepo.findOne(id);
			movieRepo.delete(id);
			;
			return movie;
		} catch (org.springframework.dao.EmptyResultDataAccessException erdae) {
			return null;
		}
	}

	@PostMapping("{movieId}/actors")
	public Movie  associateAnActor(@PathVariable long movieId, @RequestBody Actor actor) {
		Movie movie = movieRepo.findOne(movieId);
		actor = actorRepo.findOne(actor.getId());
		
		movie.getActors().add(actor);
		movieRepo.save(movie);
		
		return movie;
	}

}