package pl.aogiri.hhu.fsa.backend.showtime.application.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeTextSourceType;
import pl.aogiri.hhu.fsa.backend.showtime.domain.enums.ShowtimeVideoType;

import java.time.LocalDateTime;

@Data
public class ShowtimeDto {

    private Long id;

    private String cinemaFacilityName;
    private String movieTitle;
    private ShowtimeVideoType videoType;
    private ShowtimeTextSourceType textType;
    private String textLanguage;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime;
}
