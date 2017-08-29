package com.libertymutual.goforcode.wimp.api;

import java.util.Date;
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
import com.libertymutual.goforcode.wimp.services.ActorRepo;

@RestController
@RequestMapping("/api/actors")

public class ActorApiController {

	private ActorRepo actorRepo;
	
	public ActorApiController(ActorRepo actorRepo) {
		this.actorRepo = actorRepo;
		
		
//		actorRepo.save(new Actor("", "",) new Date(Date.parse("8/23/1999");
//		actor.setBirthDate(new Date(Date.parse("8/23/1972")))
		
		Actor actor = new Actor();
		actorRepo.save(new Actor("actor1firstname","actor1lasttname" ));
		actorRepo.save(new Actor("actor2firstname","actor2lasttname" ));
		actorRepo.save(new Actor("actor3firstname","actor3lasttname" ));
		actorRepo.save(new Actor("actor4firstname","actor4lasttname" ));
	}
	
	@GetMapping("")
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Actor getOne(@PathVariable long id) throws StuffNotFoundException {
		Actor actor = actorRepo.findOne(id);
		if (actor == null) {
			throw new StuffNotFoundException();
		}
		return actor;
	}
	
	@PostMapping("")
	public Actor create(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}
	
	@PutMapping("{id}")
	public Actor update(@RequestBody Actor actor,@PathVariable long id) {
		actor.setId(id);
		return actorRepo.save(actor);
	}

	@DeleteMapping("{id}")
	public Actor delete(@PathVariable long id) {
		try {
			Actor actor = actorRepo.findOne(id);
			actorRepo.delete(id);
			;
			return actor;
		} catch (org.springframework.dao.EmptyResultDataAccessException erdae) {
			return null;
		}
	}
	
}
