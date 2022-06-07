package com.tsi.yasir.siddig.myMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@RequestMapping("/")
public class MyMicroServiceApplication {

	@Autowired
	private IActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyMicroServiceApplication.class, args);
	}

	public MyMicroServiceApplication(IActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors() {
		return actorRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Actor> addActor(@RequestBody Actor actor) {
		Actor newActor = actorRepository.save(actor);
		return ResponseEntity.status(HttpStatus.CREATED).body(newActor);
	}



}
