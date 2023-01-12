package pl.aogiri.hhu.fsa.backend.genre.application.mapper;

import org.junit.jupiter.api.Test;
import pl.aogiri.hhu.fsa.backend.genre.application.dto.GenreDto;
import pl.aogiri.hhu.fsa.backend.genre.domain.entity.GenreEntity;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.GenreDtoFixture;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.GenreEntityFixture;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GenreMapperTest {

    @Test
    public void shouldSuccessfullyMapEntityToDtoWhenCorrectEntityIsGiven() {
        //given
        final var givenEntity = GenreEntityFixture.action();

        //when
        final GenreDto actualDto = GenreMapper.toDto(givenEntity);

        //then
        assertThat(actualDto).isEqualTo(GenreDtoFixture.action());
    }

    @Test
    public void shouldSuccessfullyMapDtoToEntityWhenCorrectDtoIsGiven(){
        //given
        final var givenDto = GenreDtoFixture.action();

        //when
        final GenreEntity actualEntity = GenreMapper.toEntity(givenDto);

        //then
        assertThat(actualEntity).isEqualTo(GenreEntityFixture.action());
    }
}
