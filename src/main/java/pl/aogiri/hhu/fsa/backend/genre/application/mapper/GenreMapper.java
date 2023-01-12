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

    public static GenreEntity toEntity(GenreDto genreDto) {
        final var genreEntity = new GenreEntity();
        genreEntity.setId(genreDto.getId());
        genreEntity.setName(genreDto.getName());
        return genreEntity;
    }
}
