package pl.aogiri.hhu.fsa.backend.genre.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.aogiri.hhu.fsa.backend.common.ErrorResponse;
import pl.aogiri.hhu.fsa.backend.genre.exception.GenreNotFoundException;

@ResponseBody
@ControllerAdvice
public class GenreControllerAdvice {
    @ExceptionHandler(GenreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse genreNotFoundException(GenreNotFoundException ex) {
        return ErrorResponse.of(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
