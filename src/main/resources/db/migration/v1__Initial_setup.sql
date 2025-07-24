-- USERS
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    profile_id BIGINT
);

-- PROFILES (assumed since User has a Profile reference)
CREATE TABLE profile (
    id SERIAL PRIMARY KEY
    -- Add fields as needed later
);

ALTER TABLE users
ADD CONSTRAINT fk_users_profile
FOREIGN KEY (profile_id) REFERENCES profile(id);

-- COURSES
CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);

-- TOPICS
CREATE TABLE topics (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    created_date TIMESTAMP NOT NULL,
    status VARCHAR(100),
    author_id BIGINT,
    course_id BIGINT
);

ALTER TABLE topics
ADD CONSTRAINT fk_topics_author
FOREIGN KEY (author_id) REFERENCES users(id);

ALTER TABLE topics
ADD CONSTRAINT fk_topics_course
FOREIGN KEY (course_id) REFERENCES courses(id);

-- ANSWERS
CREATE TABLE answers (
    id SERIAL PRIMARY KEY,
    message TEXT NOT NULL,
    topic_id BIGINT,
    created_date TIMESTAMP NOT NULL,
    author_id BIGINT,
    solution VARCHAR(255)
);

ALTER TABLE answers
ADD CONSTRAINT fk_answers_topic
FOREIGN KEY (topic_id) REFERENCES topics(id);

ALTER TABLE answers
ADD CONSTRAINT fk_answers_author
FOREIGN KEY (author_id) REFERENCES users(id);

-- TOPIC <-> ANSWERS relationship (List<Answer> in Topic)
-- NOTE: JPA OneToMany unidirectional doesn't need a join table if it's mapped via FK on the child (which it is here via topic_id in answers).
-- So nothing extra needed here.
