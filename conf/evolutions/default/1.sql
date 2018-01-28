# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table coding_question (
  id                            bıgınt auto_increment not null,
  question_content              TEXT,
  category                      ınteger not null,
  difficulty                    ınteger not null,
  time_to_solve                 ınteger not null,
  testcases                     TEXT,
  outputs                       TEXT,
  programming_language          varchar(255),
  base_code                     TEXT,
  constraint pk_coding_question primary key (id)
);

create table multiple_choice (
  id                            bıgınt auto_increment not null,
  question_content              TEXT,
  category                      ınteger not null,
  difficulty                    ınteger not null,
  time_to_solve                 ınteger not null,
  choice1                       varchar(255),
  choice2                       varchar(255),
  choice3                       varchar(255),
  choice4                       varchar(255),
  correct_answer                varchar(255),
  constraint pk_multiple_choice primary key (id)
);

create table profile_pic (
  id                            bıgınt auto_increment not null,
  pic                           blob,
  constraint pk_profile_pic primary key (id)
);

create table statistics (
  id                            bıgınt auto_increment not null,
  user_email                    varchar(255) not null,
  correct                       integer default 0 not null,
  wrong                         integer default 0 not null,
  category                      integer default 0 not null,
  constraint pk_statistics primary key (id)
);

create table user (
  email                         varchar(255) not null,
  password                      TEXT,
  name                          varchar(255),
  profile_pic_id                bıgınt,
  bio                           varchar(255),
  constraint uq_user_profile_pic_id unique (profile_pic_id),
  constraint pk_user primary key (email)
);

alter table statistics add constraint fk_statistics_user_email foreign key (user_email) references user (email) on delete restrict on update restrict;
create index ix_statistics_user_email on statistics (user_email);

alter table user add constraint fk_user_profile_pic_id foreign key (profile_pic_id) references profile_pic (id) on delete restrict on update restrict;


# --- !Downs

alter table statistics drop constraint if exists fk_statistics_user_email;
drop index if exists ix_statistics_user_email;

alter table user drop constraint if exists fk_user_profile_pic_id;

drop table if exists coding_question;

drop table if exists multiple_choice;

drop table if exists profile_pic;

drop table if exists statistics;

drop table if exists user;

