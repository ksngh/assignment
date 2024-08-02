CREATE USER 'study'@'localhost' IDENTIFIED BY '1234';

grant all privileges on *.* to 'study'@'localhost';

flush privileges;