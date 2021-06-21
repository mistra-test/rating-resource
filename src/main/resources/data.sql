CREATE TABLE IF NOT EXISTS rating (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    movie_id INT NOT NULL,
    score INT NOT NULL
);

INSERT INTO rating (id, user_id, movie_id, score) VALUES
  (1, 1, 1, 5),
  (2, 1, 2, 3),
  (3, 2, 2, 4),
  (4, 2, 3, 2);