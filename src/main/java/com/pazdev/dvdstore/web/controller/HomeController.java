package com.pazdev.dvdstore.web.controller;

import com.pazdev.dvdstore.core.entity.Movie;
import com.pazdev.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("dvdstore-home")
public class HomeController {

    @Autowired
    private MovieServiceInterface movieService;

    public HomeController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    public MovieServiceInterface getMovieServiceInterface() {
        return movieService;
    }

    public void setMovieServiceInterface(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @RequestMapping
    public String displayHome(Model model) {
        model.addAttribute("movies", movieService.getMovieList());
        return "dvdstore-home";
    }
}
