DROP TABLE IF EXISTS books;

CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  page_count INT NOT NULL,
  author_id INT NOT NULL
);

DROP TABLE IF EXISTS authors;

CREATE TABLE authors (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
);

INSERT INTO authors (first_name, last_name) VALUES
  ('Jhon', 'Doe'),
  ('Joanne', 'Rowling'),
  ('Herman', 'Melville'),
  ('Anne', 'Rice');

INSERT INTO books (name, page_count, author_id) VALUES
  ('Harry Potter and the Philosopher Stone', 223, 1),
  ('Moby Dick', 635, 2),
  ('Interview with the vampire', 371, 3);
