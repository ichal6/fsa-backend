package pl.aogiri.hhu.fsa.backend.movie.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.movie.application.MovieService;
import pl.aogiri.hhu.fsa.backend.movie.application.dto.MovieDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieControllerImpl implements MovieController {
    private final MovieService movieService;

    @Override
    public List<MovieDto> getMovies() {
        return movieService.getAllMovies();
    }
}
