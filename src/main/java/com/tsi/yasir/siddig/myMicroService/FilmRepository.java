package com.tsi.yasir.siddig.myMicroService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpEntity;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}
