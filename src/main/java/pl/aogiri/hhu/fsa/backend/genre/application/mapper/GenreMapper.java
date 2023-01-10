package pl.aogiri.hhu.fsa.backend.genre.application.mapper;

import pl.aogiri.hhu.fsa.backend.genre.application.dto.GenreDto;
import pl.aogiri.hhu.fsa.backend.genre.domain.entity.GenreEntity;

public class GenreMapper {

    public static GenreDto toDto(GenreEntity genreEntity) {
        final var genreDto = new GenreDto();
        genreDto.setId(genreEntity.getId());
        genreDto.setName(genreEntity.getName());
        return genreDto;
    }
}
