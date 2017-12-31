# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table coding_question (
  id                            bıgınt auto_increment not null,
  question_content              varchar(255),
  category                      ınteger not null,
  difficulty                    ınteger not null,
  time_to_solve                 ınteger not null,
  inputs                        varchar(255),
  outputs                       varchar(255),
  programming_language          varchar(255),
  constraint pk_coding_question primary key (id)
);

create table multiple_choice (
  id                            bıgınt auto_increment not null,
  question_content              varchar(255),
  category                      ınteger not null,
  difficulty                    ınteger not null,
  time_to_solve                 ınteger not null,
  choices                       varchar(255),
  constraint pk_multiple_choice primary key (id)
);

create table user (
  email                         varchar(255) not null,
  password                      varchar(255),
  name                          varchar(255),
  test_statistics               varchar(255),
  profile_pic                   varchar(255),
  bio                           varchar(255),
  constraint pk_user primary key (email)
);


# --- !Downs

drop table if exists coding_question;

drop table if exists multiple_choice;

drop table if exists user;

