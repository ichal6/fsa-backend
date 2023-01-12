package pl.aogiri.hhu.fsa.backend.genre.exception;

import static java.lang.String.format;

public class GenreNotFoundException extends RuntimeException {

    public GenreNotFoundException(long genreId) {
        super(format("Genre with id %d not found", genreId));
    }
}
