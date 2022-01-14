package com.pazdev.dvdstore.web.controller;

import com.pazdev.dvdstore.core.service.DefaultMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") long id, Model model){
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movie-details";
    }
}
