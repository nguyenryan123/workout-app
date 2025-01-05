CREATE TABLE account (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    passkey VARCHAR(50) NOT NULL
);

--CREATE TABLE workout (
--    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    user_id INT NOT NULL,
--    dt DATE NOT NULL,
--    name VARCHAR(50) NOT NULL
--);
--
--CREATE TABLE workout_set (
--    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    user_id INT NOT NULL,
--    workout_id INT NOT NULL,
--    weight DOUBLE NOT NULL,
--    reps INT NOT NULL
--);