create table showtime
(
    id bigserial not null,
    datetime      timestamp,
    text_language varchar(255),
    text_type     varchar(255) not null,
    video_type    varchar(255) not null,
    cinema_facility_id int8,
    movie_id int8,
    primary key (id)
);

alter table showtime
    add constraint FK68vc0i90o2o6onts4vnxxngpb foreign key (cinema_facility_id) references cinema_facility;

alter table showtime
    add constraint FK8i90asti16tydhva795c3qwj2 foreign key (movie_id) references movie;