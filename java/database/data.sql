BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO pets (gender, pet_name, animal_type, color, age, image_link, tagline)
        VALUES  ('male', 'Alfred', 'cat', 'brown', 2, 'img/alfred.jpg', 'I am a complete professional butler, ready to serve and be served. Pick me'),
                ('male', 'Baxter', 'dog', 'black', 4, 'img/baxter.webp', 'Woof! I love to play fetch & fetch toys are my favorite'),
                ('female','Beethoven','cat', 'striped brown', 0.3, 'img/beethoven.jpg', 'I am so cute! I love to play and cuddle.'),
                ('female', 'Chaz', 'dog', 'light brown', 3, 'img/chaz.jpg' , 'Am I close enough to the camera to make you want me? Zoom in'),
                ('female', 'Fifi', 'dog', 'white and brown', 6, 'img/fifi.jpg', 'A loyal dog who just wants a human friend to love'),
                ('male', 'Garfunkel', 'cat', 'caramel', 7, 'img/garfunkle.jpg', 'Come play with me for a purrfect time'),
                ('female', 'Kutie', 'cat', 'cream', 2, 'img/kutie.jpg', 'Just give me a bowl of the best and I am yours for the rest of time'),
                ('male', 'Sputnik', 'dog', 'black', 4, 'img/sputnik.jpg', 'A big strong Dog looking for a cute human to protect'),
                ('female', 'Stinky', 'cat', 'midnight black', 3, 'img/stinky.jpg', 'I hate to bathe but I love to play!'),
                ('male', 'Stumps', 'dog', 'tan', 1, 'img/stumps.jpg', 'The laziest but most loveable dog ever. Cuddle with me.'),
                ('female', 'Zippers', 'bunny', 'grey with white face', 2, 'img/zippers.jpg', 'Nom Nom Nom I love to eat and look so cute.');

COMMIT TRANSACTION;
