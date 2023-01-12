package pl.aogiri.hhu.fsa.backend.genre.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.aogiri.hhu.fsa.backend.genre.application.dto.GenreDto;
import pl.aogiri.hhu.fsa.backend.genre.domain.entity.GenreEntity;

import java.util.List;

@Tag(
        name = "Genre Controller",
        description = "Provide operations for genre"
)
@RequestMapping("/genres")
public interface GenreController {

    @Operation(summary = "Get all available genres")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(
            value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    default List<GenreDto> getGenres() {
        throw new NotImplementedException();
    }

    @Operation(summary = "Edit genre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Genre updated successfully"),
            @ApiResponse(responseCode = "400", description = "Requested data are incorrect"),
            @ApiResponse(responseCode = "500", description = "Error occurred when adding a cinema")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @PutMapping(
            value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @PreAuthorize("hasRole('GENRE_EDIT')")
    default GenreEntity editGenre(@RequestBody GenreDto genreDto) {
        throw new NotImplementedException();
    }
}
