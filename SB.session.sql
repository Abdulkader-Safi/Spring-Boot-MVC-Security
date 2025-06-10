DROP TABLE IF EXISTS users;

CREATE TABLE
    IF NOT EXISTS users (
        username VARCHAR(50) NOT NULL,
        password VARCHAR(50) NOT NULL,
        enabled TINYINT NOT NULL,
        PRIMARY KEY (username)
    );

INSERT INTO
    users
VALUES
    ("admin", "{noop}admin", 1),
    ("manager", "{noop}manager", 1),
    ("employee", "{noop}employee", 1);

DROP TABLE IF EXISTS authorities;

CREATE TABLE
    IF NOT EXISTS authorities (
        username VARCHAR(50) NOT NULL,
        authority VARCHAR(50) NOT NULL,
        UNIQUE KEY authorities_idx_1 (username, authority),
        CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
    );

INSERT INTO
    authorities
VALUES
    ("admin", "ROLE_ADMIN"),
    ("admin", "ROLE_MANAGER"),
    ("admin", "ROLE_EMPLOYEE"),
    ("manager", "ROLE_MANAGER"),
    ("manager", "ROLE_EMPLOYEE"),
    ("employee", "ROLE_EMPLOYEE");