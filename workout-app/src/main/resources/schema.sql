CREATE TABLE account (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    passkey VARCHAR(50) NOT NULL
);

CREATE TABLE workout (
    workout_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    workout_name VARCHAR(50) NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES account(id) ON DELETE CASCADE,
    CONSTRAINT unique_user_workout UNIQUE (user_id, workout_name)
);

CREATE TABLE workout_set (
    set_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    weight DOUBLE NOT NULL,
    reps INT NOT NULL,
    workout_id INT NOT NULL,
    workout_date DATE,
    CONSTRAINT fk_workout_id FOREIGN KEY (workout_id) REFERENCES workout(workout_id) ON DELETE CASCADE
);