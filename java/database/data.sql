BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO pets (gender, pet_name, animal_type, color, age, image_link, tagline)
        VALUES  ('male', 'Alfred', 'cat', 'brown', 2, '/img/alfred.jpg', 'I am in need of a human. Pick me!'),
                ('female','Beethoven','cat', 'striped brown', 0.3, '/img/beethoven.jpg', 'I am so cute! I love to play and cuddle!'),
                ('female', 'Fifi', 'dog', 'white and brown', 6, '/img/fifi.jpg', 'A loyal dog who just wants a human friend to love!'),
                ('male', 'Garfunkel', 'cat', 'caramel', 7, '/img/garfunkel.jpg', 'Come play with me for a purrfect time!'),
                ('female', 'Kutie', 'cat', 'cream', 2, '/img/kutie.jpg', 'Just give me a bowl of the best and I am yours for the rest of time!'),
                ('female', 'Stinky', 'dog', 'midnight black', 3, '/img/stinky.jpg', 'I hate to bathe but I love to play!'),
                ('female', 'Zippers', 'bunny', 'grey with white face', 2, '/img/zippers.jpg', 'Nom Nom Nom I love to eat and look so cute!'),
                ('male', 'Dingus', 'cat', 'black', 1, '/img/dingus.png', 'I scream with joy to play with toys...and I am super cute!');


INSERT INTO volunteers (username, password, role, email, phone, name)
        VALUES ('Joseph123', 'finalcapstone', 'volunteer', 'joseph123@gmail.com', 5551111, 'Joseph Stephens'),
                ('Abigal456', 'finalcapstone', 'volunteer', 'abigail456@gmail.com', 5552222, 'Abigail Newman'),
                ('Adam789', 'finalcapstone', 'volunteer', 'adam789@gmail.com', 5553333, 'Adam Shaw'),
                ('Ruina101112', 'finalcapstone', 'volunteer', 'ruina101112@gmail.com', 5554444, 'Ruina Kang');


COMMIT TRANSACTION;
