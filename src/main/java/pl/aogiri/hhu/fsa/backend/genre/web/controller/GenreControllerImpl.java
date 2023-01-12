package pl.aogiri.hhu.fsa.backend.genre.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.aogiri.hhu.fsa.backend.genre.application.GenreService;
import pl.aogiri.hhu.fsa.backend.genre.application.dto.GenreDto;
import pl.aogiri.hhu.fsa.backend.genre.domain.entity.GenreEntity;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GenreControllerImpl implements GenreController {
    private final GenreService genreService;

    @Override
    public List<GenreDto> getGenres() {
        return genreService.getAllGenres();
    }

    @Override
    public GenreEntity addGenre(@RequestBody GenreDto genreDto) {
        return genreService.editGenre(genreDto);
    }
}
