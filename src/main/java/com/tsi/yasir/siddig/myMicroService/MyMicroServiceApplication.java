package com.tsi.yasir.siddig.myMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

	@GetMapping("/Get_Actors_By_Id")
	public @ResponseBody
	Optional<Actor> getAnActor(@RequestParam int id) {
		return actorRepository.findById(id);
	}

	@PostMapping("/Add_Actor")
	public ResponseEntity<Actor> addActor(@RequestParam String first_name, String last_name) {
		Actor newActor = new Actor(first_name, last_name);
		actorRepository.save(newActor);
		return ResponseEntity.ok(newActor);
	}

	@PutMapping("/Update_Actor")
	public ResponseEntity<Actor> addNewActor(@RequestParam int id, String first_name, String last_name) throws ResourceNotFoundException {
		Actor updateActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with id: " + id));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		actorRepository.save(updateActor);
		return ResponseEntity.ok(updateActor);
	}

	@DeleteMapping("/Delete_Actor")
	public ResponseEntity<Actor> deleteActor(@RequestParam int id) {
		Actor removeActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with id: " + id));
		actorRepository.deleteById(id);
		return ResponseEntity.ok(removeActor);
	}



}
