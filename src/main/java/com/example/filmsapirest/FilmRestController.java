package com.example.filmsapirest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmRestController {

    private List<Film> films = new ArrayList<>();

    @PostMapping("/films")
    public Film createFilm(@RequestBody Film filmToCreate) {
        films.add(filmToCreate);
        return filmToCreate;
    }


    @GetMapping("/films")
    public List<Film> getFilms() throws Exception {
        return films;
    }

    @GetMapping("/films/{title}")
    public Film getFilm(@PathVariable String title) throws Exception {
        for (Film film : new ArrayList<>(films)) {
            if (film.getTitle().equals(title)) {
                return film;
            }
        }
        throw new Exception("No s' ha trobat");
    }

    @DeleteMapping("/films")
    public void removeAllFilm() {
        films = new ArrayList<>();
    }

    @DeleteMapping("/films/{title}")
    public void removeFilm(@PathVariable String title) {
        for (Film film : new ArrayList<>(films)) {
            if (film.getTitle().equals(title)) {
                films.remove(film);
            }
        }
    }

    @PutMapping("/film/{title}")
    public void updateFilm(@RequestBody Film filmToUpdate, @PathVariable String title) throws Exception {
        for (Film film : new ArrayList<>(films)) {
            if (film.getTitle().equals(title)) {
                film.setAuthor(filmToUpdate.getAuthor());
                film.setIsPorn(filmToUpdate.isPorn());
                return;
            }
        }
        throw new Exception("No s' ha trobat");
    }


}
