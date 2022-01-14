package com.pazdev.dvdstore.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {
    private Long id;
    @NotBlank(message = "Veuillez entrer un titre")
    @Size(max = 20)
    private String title;
    @NotBlank(message = "Veuillez entrer un genre")
    private String genre;
    @Size(max = 255, message = "Entrez une description de 255 caractères maximum")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
