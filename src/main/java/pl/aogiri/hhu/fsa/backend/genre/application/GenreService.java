package pl.aogiri.hhu.fsa.backend.genre.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aogiri.hhu.fsa.backend.genre.application.dto.GenreDto;
import pl.aogiri.hhu.fsa.backend.genre.application.mapper.GenreMapper;
import pl.aogiri.hhu.fsa.backend.genre.domain.entity.GenreEntity;
import pl.aogiri.hhu.fsa.backend.genre.domain.repository.GenreRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public List<GenreDto> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(GenreMapper::toDto)
                .toList();
    }

    public List<GenreEntity> getAllGenresForIds(List<Long> genresIds) {
        return genreRepository.findAllByIdIn(genresIds);
    }
}
