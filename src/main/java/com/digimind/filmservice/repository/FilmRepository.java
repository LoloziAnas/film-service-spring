package com.digimind.filmservice.repository;
import com.digimind.filmservice.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByGenreContainingIgnoreCase(String genre);
}

