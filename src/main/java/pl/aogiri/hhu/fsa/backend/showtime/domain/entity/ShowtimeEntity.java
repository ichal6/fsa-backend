package pl.aogiri.hhu.fsa.backend.showtime.domain.entity;

import lombok.Data;
import pl.aogiri.hhu.fsa.backend.cinema.domain.entity.CinemaFacilityEntity;
import pl.aogiri.hhu.fsa.backend.movie.domain.entity.MovieEntity;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeTextSourceType;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeVideoType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "showtime")
public class ShowtimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private MovieEntity movie;

    @OneToOne
    private CinemaFacilityEntity cinemaFacility;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ShowtimeVideoType videoType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ShowtimeTextSourceType textType;

    @NotEmpty
    private String textLanguage;

    private LocalDateTime datetime;
}
