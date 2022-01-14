package com.pazdev.dvdstore.web.api;

import com.pazdev.dvdstore.core.entity.Movie;
import com.pazdev.dvdstore.core.service.DefaultMovieService;
import com.pazdev.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @Autowired
    private DefaultMovieService movieService = new DefaultMovieService();

    public DefaultMovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(DefaultMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> list() {
        return movieService.getMovieList();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") long id){
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie) {
        return movieService.registerMovie(movie);
    }
}
