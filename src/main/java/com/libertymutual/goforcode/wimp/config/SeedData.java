package com.libertymutual.goforcode.wimp.config;

import org.springframework.context.annotation.Configuration;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.services.ActorRepo;
import com.libertymutual.goforcode.wimp.services.MovieRepo;

@Configuration
public class SeedData {

	public SeedData(MovieRepo movieRepo, ActorRepo actorRepo) {
		movieRepo.save(new Movie("movie1"));
		movieRepo.save(new Movie("movie2"));
		movieRepo.save(new Movie("movie3"));
		movieRepo.save(new Movie("movie4"));
		movieRepo.save(new Movie("movie5"));
		movieRepo.save(new Movie("movie6"));
		movieRepo.save(new Movie("movie7"));
		movieRepo.save(new Movie("movie8"));
		Movie movie = movieRepo.save(new Movie("movie9"));
		

		actorRepo.save(new Actor("Actor1", "actor1"));
		actorRepo.save(new Actor("Actor2", "actor2"));
		actorRepo.save(new Actor("Actor3", "actor3"));
		actorRepo.save(new Actor("Actor4", "actor4"));
		actorRepo.save(new Actor("Actor5", "actor5"));
		actorRepo.save(new Actor("Actor6", "actor6"));
		actorRepo.save(new Actor("Actor7", "actor7"));
		actorRepo.save(new Actor("Actor8", "actor8"));
		actorRepo.save(new Actor("Actor9", "actor9"));
		Actor actor = actorRepo.save(new Actor("Actor10", "actor10"));
		movie.addActor(actor);
		movieRepo.save(movie);
	}
	
}
