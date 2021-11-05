DROP DATABASE IF EXISTS SoundMapDB;

CREATE SCHEMA SoundMapDB;

USE SoundMapDB;

CREATE TABLE User (
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(30) NOT NULL,
    first_name TEXT,
    last_name TEXT,
    balance INT DEFAULT 0,
    rating INT DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE SynthPreset (
    id INT NOT NULL AUTO_INCREMENT,
    name TEXT,
    gate double,
    attack double,
    decay double,
    sustain double,
    release_synth double,
    cutoff double,
    threshold double,
    polyphony double,

    price int,
    primary key (id)
);

CREATE TABLE MusicalInstrument (
    name VARCHAR(20) PRIMARY KEY NOT NULL ,
    premium boolean default FALSE
);

CREATE TABLE Music (
    id INT NOT NULL AUTO_INCREMENT,
    type VARCHAR(10) NOT NULL,
    genre VARCHAR(30),
    name TEXT NOT NULL,
    author TEXT NOT NULL ,
    sheets_url VARCHAR(100) default 'https://www.youtube.com/watch?v=dQw4w9WgXcQ',
    price int default 0,
    rating int default 0,
    premium boolean default false,
    primary key (id)
);

CREATE TABLE UserMusic (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    music_id INT NOT NULL,
    foreign key (user_id) references User(id) ON DELETE CASCADE ,
    foreign key (music_id) references Music(id) ON DELETE CASCADE
);

CREATE TABLE MusicPreset (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    music_id INT NOT NULL,
    preset_id INT NOT NULL ,
    foreign key (music_id) references Music(id) ON DELETE CASCADE ON UPDATE CASCADE ,
    foreign key (preset_id) references SynthPreset(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE MusicInstruments (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    music_id INT NOT NULL,
    instrument_name VARCHAR(20) NOT NULL ,
    foreign key (music_id) references Music(id) ON DELETE CASCADE ON UPDATE CASCADE ,
    foreign key (instrument_name) references MusicalInstrument(name) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into User ( email, password, first_name, last_name, balance, rating)
values ('890readrid@gmail.com', 'hsepassword', 'Vova', 'Fedorov', 20, 100);


