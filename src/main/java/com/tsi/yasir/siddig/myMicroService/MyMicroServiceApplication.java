package com.tsi.yasir.siddig.myMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class MyMicroServiceApplication {

	@Autowired
	private ActorRepository actorRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private FilmRepository filmRepo;
	@Autowired
	private LanguageRepository languageRepo;

	public static void main(String[] args) {
		SpringApplication.run(MyMicroServiceApplication.class, args);
	}


	public MyMicroServiceApplication(ActorRepository actorRepo, CategoryRepository categoryRepo, FilmRepository filmRepo, LanguageRepository languageRepo) {
		this.actorRepo = actorRepo;
		this.categoryRepo = categoryRepo;
		this.filmRepo = filmRepo;
		this.languageRepo = languageRepo;
	}

	// ACTOR CRUD METHODS

	@GetMapping("/All_Actors")
	public @ResponseBody Iterable<Actor> getAllActors() {
		return actorRepo.findAll(); }

	@GetMapping("/Get_Actors_By_Id")
	public @ResponseBody
	Optional<Actor> getAnActor(@RequestParam int id) {
		return actorRepo.findById(id);
	}

	@PostMapping("/Add_Actor")
	public ResponseEntity<Actor> addActor(@RequestParam String first_name, String last_name) {
		Actor newActor = new Actor(first_name, last_name);
		actorRepo.save(newActor);
		return ResponseEntity.ok(newActor);
	}

	@PutMapping("/Update_Actor")
	public ResponseEntity<Actor> addNewActor(@RequestParam int id, String first_name, String last_name) throws ResourceNotFoundException {
		Actor updateActor = actorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with id: " + id));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		actorRepo.save(updateActor);
		return ResponseEntity.ok(updateActor);
	}

	@DeleteMapping("/Delete_Actor")
	public ResponseEntity<Actor> deleteActor(@RequestParam int id) {
		Actor removeActor = actorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with id: " + id));
		actorRepo.deleteById(id);
		return ResponseEntity.ok(removeActor);
	}

	// CATEGORY CRUD METHODS

	@GetMapping("/All_Category")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepo.findAll();
	}

	@GetMapping("/Get_Category")
	public ResponseEntity<Category> getCategory(@RequestParam Integer category_id){
		Category category = categoryRepo.findById(category_id)
				.orElseThrow(() -> new ResourceNotFoundException("Category does not exist with ID: " + category_id));
		return ResponseEntity.ok(category);
	}

	@PostMapping("/Add_Category")
	public @ResponseBody ResponseEntity<Category> addCategory(@RequestBody Category addCategory){

		categoryRepo.save(addCategory);
		return ResponseEntity.ok(addCategory);
	}

	@PutMapping("/Update_Category")
	public ResponseEntity<Category> updateCategory(@RequestBody Category alterCategory){
		Category updateCategory = categoryRepo.findById(alterCategory.getCategory_id())
				.orElseThrow(() -> new ResourceNotFoundException("Category does not exist with id: "));
		categoryRepo.save(updateCategory);
		return ResponseEntity.ok(updateCategory);
	}

	@DeleteMapping("/Delete_Category")
	public ResponseEntity<Category> deleteCategory(@RequestBody Category deleteCategory){

		Category removeCategory = categoryRepo.findById(deleteCategory.getCategory_id())
				.orElseThrow(() -> new ResourceNotFoundException("Category does not exist with id: "));
		categoryRepo.deleteById(removeCategory.getCategory_id());
		return ResponseEntity.ok(removeCategory);
	}

	// FILM CRUD METHODS

	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepo.findAll();
	}

	@GetMapping("/Get_Film")
	public ResponseEntity<Film> getFilm(@RequestParam Integer film_id){
		Film film = filmRepo.findById(film_id)
				.orElseThrow(() -> new ResourceNotFoundException("Film does not exist with ID: " + film_id));
		return ResponseEntity.ok(film);
	}

	@PostMapping("/Add_Film")
	public @ResponseBody ResponseEntity<Film> addFilm(@RequestBody Film addFilm) {

		filmRepo.save(addFilm);
		return ResponseEntity.ok(addFilm);
	}

	@PutMapping("/Update_Film")
	public ResponseEntity<Film> updateFilm(@RequestParam Film alterFilm){
		Film updateFilm = filmRepo.findById(alterFilm.getFilm_id())
				.orElseThrow(() -> new ResourceNotFoundException("Film does not exist with id: "));

//		updateFilm.setFilm_id(film_id);
//		updateFilm.setTitle(title);
//		updateFilm.setDescription(description);
//		updateFilm.setRelease_year(release_year);
//		updateFilm.setLanguage(language);
//		updateFilm.setOriginal_language_id(original_language_id);
//		updateFilm.setLength(length);
//		updateFilm.setRating(rating);
		filmRepo.save(updateFilm);
		return ResponseEntity.ok(updateFilm);
	}

//	@RequestParam Integer film_id, String title, String description, Date release_year, Language language, Integer original_language_id, int length, String rating

	@DeleteMapping("/Delete_Film")
	public ResponseEntity<Film> deleteFilm(@RequestBody Film deleteFilm){

		Film removeFilm = filmRepo.findById(deleteFilm.getFilm_id())
				.orElseThrow(() -> new ResourceNotFoundException("Film does not exist with id: "));

		filmRepo.deleteById(removeFilm.getFilm_id());
		return ResponseEntity.ok(removeFilm);
	}

	// LANGUAGE CRUD METHODS

	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepo.findAll();
	}

	@GetMapping("/Get_Language")
	public ResponseEntity<Language> getLanguage(@RequestParam int language_id){
		Language language = languageRepo.findById(language_id)
				.orElseThrow(() -> new ResourceNotFoundException("Language does not exist with ID: " + language_id));
		return ResponseEntity.ok(language);
	}

	@PostMapping("/Add_Language")
	public @ResponseBody ResponseEntity<Language> addLanguage(@RequestBody Language addLanguage){

		languageRepo.save(addLanguage);
		return ResponseEntity.ok(addLanguage);
	}

	@PutMapping("/Update_Language")
	public ResponseEntity<Language> updateLanguage(@RequestBody Language alterLanguage){
		Language updateLanguage = languageRepo.findById(alterLanguage.getLanguage_id())
				.orElseThrow(() -> new ResourceNotFoundException("Language does not exist with id: "));

		updateLanguage.setLanguage_id(updateLanguage.getLanguage_id());
		languageRepo.save(updateLanguage);
		return ResponseEntity.ok(updateLanguage);
	}

	@DeleteMapping("/Delete_Language")
	public ResponseEntity<Language> deleteLanguage(@RequestBody Language deleteLanguage){

		Language removeLanguage = languageRepo.findById(deleteLanguage.getLanguage_id())
				.orElseThrow(() -> new ResourceNotFoundException("Language does not exist with id: "));

		languageRepo.deleteById(removeLanguage.getLanguage_id());
		return ResponseEntity.ok(removeLanguage);
	}

}
