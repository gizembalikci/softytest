# --- Sample dataset

# --- !Ups

insert into company (id,name) values (  1,'Apple Inc.');

insert into computer (id,name,introduced,discontinued,company_id) values (  1,'MacBook Pro 15.4 inch',null,null,1);

insert into userProfile (id, nameSurname, testStatistics, profilePic, bio) values (1, 'Bilbo Baggins', 'Shire', 'Çıkın çıkmazı', 'Minik Hobbit')
insert into userProfile (id, nameSurname, testStatistics, profilePic, bio) values (2, 'Gandalf the Grey', 'Yoo', 'pff slk', 'yeter')
insert into userProfile (id, nameSurname, testStatistics, profilePic, bio) values (3, 'asdjasdha', 'gfhjkll', 'ajlsdk', 'aslkdj')
insert into userProfile (id, nameSurname, testStatistics, profilePic, bio) values (4, 'aasdsdjha', 'gfhafjkll', 'ajlsdk', 'aslkdj')
insert into userProfile (id, nameSurname, testStatistics, profilePic, bio) values (5, 'asdjha', 'gfhjkll', 'ajlsdk', 'aslkdj')

insert into userAccount (id, email, passwordHash, passwordSalt, user_id) values (1, 'aslkdjas@gmail.com', 'alksjhdkjasldj', 'alksjhdkjasldj', 1)
insert into userAccount (id, email, passwordHash, passwordSalt, user_id) values (2, 'aslkdjas@gmail.com', 'alksjhdkjasldj', 'alksjhdkjasldj', 2)
insert into userAccount (id, email, passwordHash, passwordSalt, user_id) values (3, 'aslkdjas@gmail.com', 'alksjhdkjasldj', 'alksjhdkjasldj', 3)
insert into userAccount (id, email, passwordHash, passwordSalt, user_id) values (4, 'aslkdjas@gmail.com', 'alksjhdkjasldj', 'alksjhdkjasldj', 4)
insert into userAccount (id, email, passwordHash, passwordSalt, user_id) values (5, 'aslkdjas@gmail.com', 'alksjhdkjasldj', 'alksjhdkjasldj', 5)


# --- !Downs

delete from computer;
delete from company;
delete from userProfile;
delete from userAccount;