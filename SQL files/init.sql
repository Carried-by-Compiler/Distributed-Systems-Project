/* Create tables */

CREATE TABLE users (
    `autoID`        INT NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(15) NOT NULL,
    `surname`       VARCHAR(25) NOT NULL,
    `username`      VARCHAR(20) NOT NULL UNIQUE,
    `password`      VARCHAR(255),
    `email`         VARCHAR(50) NOT NULL,
    `is_active`     TINYINT DEFAULT 1,
    `access_level`  TINYINT DEFAULT 1,

    PRIMARY KEY (`autoID`)     
);

CREATE TABLE games (
    `autoID`        INT NOT NULL AUTO_INCREMENT,
    `p1`            INT NOT NULL,
    `p2`            INT NOT NULL,
    `gameState`     TINYINT DEFAULT -1,

    PRIMARY KEY (`autoID`),
    FOREIGN KEY (`p1`) REFERENCES users(`autoID`),
    FOREIGN KEY (`p2`) REFERENCES users(`autoID`)
);

CREATE TABLE moves (
    `autoID`        INT NOT NULL AUTO_INCREMENT,
    `gID`           INT NOT NULL,
    `pID`           INT NOT NULL,
    `x`             TINYINT DEFAULT NULL,
    `y`             TINYINT DEFAULT NULL,

    PRIMARY KEY (`autoID`), 
    FOREIGN KEY (`gID`) REFERENCES games(`autoID`),
    FOREIGN KEY (`pID`) REFERENCES users(`autoID`)
);

/* Insert users */

INSERT INTO users 
VALUES (DEFAULT, 'John Rey', 'Juele', 'NoogNoog', PASSWORD('John1234'), 'john@studentmail.ul.ie', 1, 5);

INSERT INTO users 
VALUES (DEFAULT, 'Eoghan', 'Casey', 'ecasey', PASSWORD('Eoghan1234'), 'eoghan@studentmail.ul.ie', 1, 5);

INSERT INTO users 
VALUES (DEFAULT, 'Harland', 'Sanders', 'KFC <3', PASSWORD('KFC1234'), 'kfc@studentmail.ul.ie', 1, 5);

INSERT INTO users 
VALUES (DEFAULT, 'John', 'Doe', 'somename', PASSWORD('Doe1234'), 'doe@studentmail.ul.ie', 1, 5);

INSERT INTO users 
VALUES (DEFAULT, 'James', 'Murphy', 'jmurphy', PASSWORD('jmurphy1'), 'james.murphy@ul.ie', 1, 5);

/* Games details */

INSERT INTO games
VALUES (DEFAULT, 1, 2, DEFAULT);

INSERT INTO games
VALUES (DEFAULT, 4, 5, DEFAULT);

INSERT INTO games
VALUES (DEFAULT, 1, 3, DEFAULT);