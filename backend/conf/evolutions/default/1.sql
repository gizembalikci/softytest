# --- First database schema

# --- !Ups

create table userAccount (
  id                        bigint not null,
  email                     varchar(255) not null,
  passwordHash              varchar(255) not null,
  passwordSalt              varchar(255) not null,
  user_id                   bigint not null,
  constraint pk_user primary key (id))
;

CREATE TABLE userprofile (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    testStatistics VARCHAR,
    profilePic VARCHAR NOT NULL,
    bip VARCHAR NOT NULL,
    PRIMARY KEY (id)
)
;

CREATE TABLE coding (
    id BIGINT NOT NULL,
    questionContent VARCHAR,
    category INT NOT NULL,
    difficulty INT NOT NULL,
    timeToSolve INT NOT NULL,
    inputs VARCHAR NOT NULL,
    outputs VARCHAR,
    programmingLanguage VARCHAR,
    PRIMARY KEY (id)
)
;

CREATE TABLE multiplechoice (
    id BIGINT NOT NULL,
    questionContent VARCHAR,
    category INT NOT NULL,
    difficulty INT NOT NULL,
    timetosolve INT NOT NULL,
    answer VARCHAR,
    PRIMARY KEY (id)
)
;

create sequence user_seq start with 1000;

create sequence userprofile_seq start with 1000;

create sequence coding_seq start with 1;

create sequence multiplechoice_seq start with 1;

-- Emin değilim buradan
alter table userAccount add constraint fk_user_userprofile_1 foreign key (user_id) references userprofile (id) on delete restrict on update restrict
create index ix_user_userprofile_1 on userAccount (user_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists userAccount;

drop table if exists userprofile;

drop table if exists coding;

drop table if exists multiplechoice;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_seq;

drop sequence if exists userprofile_seq;

drop sequence if exists coding_seq start;

drop sequence if exists multiplechoice_seq;

