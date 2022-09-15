CREATE SCHEMA IF NOT EXISTS taxi;
create table IF NOT EXISTS taxi.vehicle
(
    id        INT,
    vendor    varchar(30) null,
    latitude  DOUBLE,
    longitude DOUBLE,
    constraint id
        primary key (id)
);

