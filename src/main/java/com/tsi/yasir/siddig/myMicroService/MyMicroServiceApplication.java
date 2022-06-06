package com.tsi.yasir.siddig.myMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@RequestMapping("/Home")
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

}
