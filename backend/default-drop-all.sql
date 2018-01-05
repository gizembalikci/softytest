alter table statistics drop constraint if exists fk_statistics_user_email;
drop index if exists ix_statistics_user_email;

alter table user drop constraint if exists fk_user_profile_pic_id;

drop table if exists coding_question;

drop table if exists multiple_choice;

drop table if exists profile_pic;

drop table if exists statistics;

drop table if exists user;

