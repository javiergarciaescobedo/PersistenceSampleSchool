ALTER TABLE STUDENT DROP CONSTRAINT CLASS_GROUP_FK;
DROP TABLE CLASS_GROUP;
DROP TABLE STUDENT;

CREATE TABLE CLASS_GROUP (
    ID INTEGER NOT NULL 
        GENERATED ALWAYS AS IDENTITY, -- AUTO_INCREMENT in MySQL
    NAME VARCHAR(50) NOT NULL,
    CAPACITY INTEGER,
    PRIMARY KEY (ID)
);

CREATE TABLE STUDENT (
    ID INTEGER NOT NULL 
        GENERATED ALWAYS AS IDENTITY,
    NAME VARCHAR(25) NOT NULL,
    SURNAMES VARCHAR(50) NOT NULL,
    DATE_BIRTH DATE,
    GRADE DECIMAL (3,1),
    CLASS_GROUP INTEGER,
    PRIMARY KEY (ID),
    CONSTRAINT CLASS_GROUP_FK FOREIGN KEY (CLASS_GROUP) REFERENCES CLASS_GROUP (ID)
);

-- Use single quotes for varchar contents
-- Date in 'yy-mm-dd' format

INSERT INTO CLASS_GROUP (NAME, CAPACITY) VALUES ('ESO1', 30);
INSERT INTO CLASS_GROUP (NAME, CAPACITY) VALUES ('BAC1', 35);
INSERT INTO CLASS_GROUP (NAME, CAPACITY) VALUES ('DAW1', 20);

INSERT INTO STUDENT (NAME, SURNAMES, DATE_BIRTH, GRADE, CLASS_GROUP) 
    VALUES ('DIEGO JESUS', 'DIEZ ALMANSA', '1996-02-24', 8.4, 2);
INSERT INTO STUDENT (NAME, SURNAMES, DATE_BIRTH, GRADE, CLASS_GROUP) 
    VALUES ('DAVID', 'GONZALEZ MAZA', '1997-04-15', 6.3, 1);
INSERT INTO STUDENT (NAME, SURNAMES, DATE_BIRTH, GRADE, CLASS_GROUP) 
    VALUES ('GEMA', 'BALBOA FUERTES', '1992-05-07', 10.0, 2);
INSERT INTO STUDENT (NAME, SURNAMES, DATE_BIRTH, GRADE, CLASS_GROUP) 
    VALUES ('YOLANDA', 'SARMIENTO PRADELL', '1995-04-20', 4.3, 3);
INSERT INTO STUDENT (NAME, SURNAMES, DATE_BIRTH, GRADE, CLASS_GROUP) 
    VALUES ('RAFAEL', 'MORAL GARCIA', '1997-01-20', 7.9, 3);
INSERT INTO STUDENT (NAME, SURNAMES, DATE_BIRTH, GRADE, CLASS_GROUP) 
    VALUES ('SUSANA', 'CAMARA SOLANO', '1997-10-18', 9.2, 1);

 