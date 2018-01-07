create table coding_question (
  id                            bigint auto_increment not null,
  question_content              varchar(255),
  category                      integer not null,
  difficulty                    integer not null,
  time_to_solve                 integer not null,
  coding_question_content       clob,
  constraint pk_coding_question primary key (id)
);

create table multiple_choice (
  id                            bigint auto_increment not null,
  question_content              varchar(255),
  category                      integer not null,
  difficulty                    integer not null,
  time_to_solve                 integer not null,
  choice1                       varchar(255),
  choice2                       varchar(255),
  choice3                       varchar(255),
  choice4                       varchar(255),
  correct_answer                varchar(255),
  constraint pk_multiple_choice primary key (id)
);

create table profile_pic (
  id                            bigint auto_increment not null,
  pic                           blob,
  constraint pk_profile_pic primary key (id)
);

create table statistics (
  id                            bigint auto_increment not null,
  user_email                    varchar(255) not null,
  correct                       integer default 0 not null,
  wrong                         integer default 0 not null,
  category                      integer default 0 not null,
  constraint pk_statistics primary key (id)
);

create table user (
  email                         varchar(255) not null,
  password                      varchar(255),
  name                          varchar(255),
  profile_pic_id                bigint,
  bio                           varchar(255),
  constraint uq_user_profile_pic_id unique (profile_pic_id),
  constraint pk_user primary key (email)
);

alter table statistics add constraint fk_statistics_user_email foreign key (user_email) references user (email) on delete restrict on update restrict;
create index ix_statistics_user_email on statistics (user_email);

alter table user add constraint fk_user_profile_pic_id foreign key (profile_pic_id) references profile_pic (id) on delete restrict on update restrict;

