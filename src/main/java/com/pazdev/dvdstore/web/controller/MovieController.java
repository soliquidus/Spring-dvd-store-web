package com.pazdev.dvdstore.web.controller;

import com.pazdev.dvdstore.core.entity.Movie;
import com.pazdev.dvdstore.core.service.DefaultMovieService;
import com.pazdev.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private DefaultMovieService movieService = new DefaultMovieService();

    public DefaultMovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(DefaultMovieService movieService) {
        this.movieService = movieService;
    }

//    @RequestMapping("/{id}")
//    public String displayMovieCard(@PathVariable("id") long id, Model model){
//        model.addAttribute("movie", movieService.getMovieById(id));
//        return "movie-details";
//    }
//
    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute MovieForm form, BindingResult results) {

        if(results.hasErrors()) {
            return "add-movie-form";
        }
        Movie movie = new Movie();
        movie.setTitle(form.getTitle());
        movie.setGenre(form.getGenre());
        movie.setDescription(form.getDescription());

        movieService.registerMovie(movie);
        return "movie-added";
    }
}
