package com.example.mycollections.controllers;

import com.example.mycollections.models.Movies;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final List<Movies> movies = new ArrayList<>() {{
        add(new Movies("Movie 1", "F. Scott Fitzgerald", 1925, 180));
        add(new Movies("Movie 2", "Harper Lee", 1960, 281));
        add(new Movies("Movie 3", "George Orwell", 1949, 328));
    }};

    @GetMapping("/json")
    public List<Movies> getMoviesJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String moviesList = "<ul>";
        for (Movies movies : movies) {
            moviesList += "<li>" + movies + "</li>";
        }
        moviesList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                moviesList +
                """
                        </ul>
                    </body>
                """;
    }

}
