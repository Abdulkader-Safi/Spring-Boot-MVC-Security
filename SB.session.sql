DROP TABLE IF EXISTS authorities;

DROP TABLE IF EXISTS users;

CREATE TABLE
    IF NOT EXISTS users (
        username VARCHAR(50) NOT NULL,
        password VARCHAR(68) NOT NULL,
        enabled TINYINT NOT NULL,
        PRIMARY KEY (username)
    );

INSERT INTO
    users
VALUES
    (
        "admin",
        "{bcrypt}$2a$10$QwSaGdR/8b7nFARs6HKMjOw/uCnvx0l6G.pO4lnfeDiVpKXGyC6Hy",
        1
    ),
    (
        "manager",
        "{bcrypt}$2a$10$kYZjy6W5qYbGyijcb4IOIOgyqM0BOmIfEGop93Vd83OPxB1ccGEcS",
        1
    ),
    (
        "employee",
        "{bcrypt}$2a$10$tgBR0m5cbiZPxhzSt9/QKuyj/s7c6k8uxmKR.mOjAbrLYyqXlQdDK",
        1
    );

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