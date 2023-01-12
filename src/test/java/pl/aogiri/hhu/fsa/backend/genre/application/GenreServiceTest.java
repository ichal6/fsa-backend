package pl.aogiri.hhu.fsa.backend.genre.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.aogiri.hhu.fsa.backend.genre.application.dto.GenreDto;
import pl.aogiri.hhu.fsa.backend.genre.domain.entity.GenreEntity;
import pl.aogiri.hhu.fsa.backend.genre.domain.repository.GenreRepository;
import pl.aogiri.hhu.fsa.backend.genre.exception.GenreNotFoundException;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.GenreDtoFixture;
import pl.aogiri.hhu.fsa.backend.movie.application.mapper.GenreEntityFixture;

import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreService genreService;

    @Test
    void shouldReturnAllGenres() {
        //given
        final var genres = List.of(GenreEntityFixture.action(), GenreEntityFixture.comedy());

        given(genreRepository.findAll()).willReturn(genres);

        //when
        final List<GenreDto> actualAllGenres = genreService.getAllGenres();

        //then
        assertThat(actualAllGenres)
                .hasSize(2)
                .containsExactlyInAnyOrder(
                        GenreDtoFixture.action(),
                        GenreDtoFixture.comedy()
                );
    }

    @Test
    void shouldReturnAllGenresForIds() {
        //given
        final var genres = List.of(GenreEntityFixture.action(), GenreEntityFixture.comedy());
        final var genresIds = List.of(1L, 2L);

        given(genreRepository.findAllByIdIn(genresIds)).willReturn(genres);

        //when
        final List<GenreEntity> actualAllGenresByIds = genreService.getAllGenresForIds(genresIds);

        //then
        assertThat(actualAllGenresByIds)
                .hasSize(2)
                .containsExactlyInAnyOrder(
                        GenreEntityFixture.action(),
                        GenreEntityFixture.comedy()
                );
    }

    @Test
    void shouldEditGenreForCorrectDto(){
        //given
        final var updatedGenreEntity = GenreEntityFixture.action();
        final var updatedGenreDto = GenreDtoFixture.action();

        given(genreRepository.existsById(updatedGenreDto.getId())).willReturn(true);
        given(genreRepository.save(any())).willReturn(updatedGenreEntity);

        //when
        final var actual = genreService.editGenre(updatedGenreDto);

        //then
        verify(genreRepository).save(updatedGenreEntity);
        assertThat(actual).isEqualTo(updatedGenreEntity);
    }

    @Test
    void shouldThrowExceptionWhenProvideWrongId(){
        //given
        final var updatedGenreDto = GenreDtoFixture.action();
        given(genreRepository.existsById(updatedGenreDto.getId())).willReturn(false);

        //when/then
        final var exception = assertThrows(
                GenreNotFoundException.class,
                () -> genreService.editGenre(updatedGenreDto)
        );

        assertThat(exception.getMessage()).isEqualTo(format("Genre with id %d not found", updatedGenreDto.getId()));
    }
}
