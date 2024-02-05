CREATE TABLE IF NOT EXISTS book
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(255) NOT NULL,
    reference VARCHAR(255) NOT NULL,
    publishing_date TIMESTAMP
);

INSERT INTO book (author, reference, publishing_date) VALUES ('Gabriel García Márquez', 'Cien años de soledad', '1967-05-30 00:00:00');
INSERT INTO book (author, reference, publishing_date) VALUES ('Jane Austen', 'Orgullo y prejuicio', '1813-01-28 00:00:00');
INSERT INTO book (author, reference, publishing_date) VALUES ('George Orwell', '1984', '1949-06-08 00:00:00');
INSERT INTO book (author, reference, publishing_date) VALUES ('Harper Lee', 'Matar a un ruiseñor', '1960-07-11 00:00:00');
