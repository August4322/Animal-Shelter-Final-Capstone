BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS volunteers;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE pets (
	id SERIAL,
	gender varchar(6),
	pet_name varchar(50) NOT NULL,
    animal_type varchar(50) NOT NULL,
	color varchar(50) NOT NULL,
	age  decimal(3,1),
	image_link varchar(250),
	is_available boolean default(true),
	spayed_neutered boolean default(true),
	tagline varchar(500),
	CONSTRAINT PK_pets PRIMARY KEY (id)
);
CREATE TABLE volunteers (
    volunteer_id SERIAL,
    username varchar(50) NOT NULL UNIQUE,
    password varchar(200) NOT NULL,
    role varchar(50) NOT NULL,
    email varchar(100) NOT NULL,
    phone int NOT NULL,
    name varchar(100) NOT NULL,
    CONSTRAINT PK_volunteer PRIMARY KEY (volunteer_id)
);




COMMIT TRANSACTION;
