
drop table if exists airports;

create table airports
(

  iata VARCHAR(3) not null,
  icao VARCHAR(10),
  name VARCHAR(150),
  city VARCHAR(150),
  country VARCHAR(150),
  lat DECIMAL,
  lon DECIMAL,
  alt DECIMAL,
  constraint airports_pkey primary key (iata)
);

