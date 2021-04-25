DROP TABLE IF EXISTS books;

CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  page_count INT NOT NULL,
  publication_date DATE NOT NULL,
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

INSERT INTO books (name, publication_date, page_count, author_id) VALUES
  ('Harry Potter and the Philosopher Stone', '1990-02-23', 223, 1),
  ('Moby Dick', '1995-02-23', 635, 2),
  ('Interview with the vampire', '1998-02-23', 371, 3);
