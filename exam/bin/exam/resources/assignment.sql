

/* Create Sequences */

CREATE SEQUENCE SEQ_PARK_SPACE_spaceId INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_T_PARK_SPACE_spaceId INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE T_OFFICER
(
	officeId number NOT NULL,
	name varchar2(20),
	officePhone varchar2(20),
	driveId number,
	spaceId number NOT NULL,
	parkName varchar2(50) NOT NULL,
	PRIMARY KEY (officeId)
);


CREATE TABLE T_PARK_ROOM
(
	parkName varchar2(50) NOT NULL,
	location varchar2(50),
	parkCars number,
	parkFloor number,
	PRIMARY KEY (parkName)
);


CREATE TABLE T_PARK_SPACE
(
	spaceId number NOT NULL,
	parkName varchar2(50) NOT NULL,
	PRIMARY KEY (spaceId, parkName)
);



/* Create Foreign Keys */

ALTER TABLE T_PARK_SPACE
	ADD FOREIGN KEY (parkName)
	REFERENCES T_PARK_ROOM (parkName)
;


ALTER TABLE T_OFFICER
	ADD FOREIGN KEY (spaceId, parkName)
	REFERENCES T_PARK_SPACE (spaceId, parkName)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_PARK_SPACE_spaceId BEFORE INSERT ON PARK_SPACE
FOR EACH ROW
BEGIN
	SELECT SEQ_PARK_SPACE_spaceId.nextval
	INTO :new.spaceId
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_T_PARK_SPACE_spaceId BEFORE INSERT ON T_PARK_SPACE
FOR EACH ROW
BEGIN
	SELECT SEQ_T_PARK_SPACE_spaceId.nextval
	INTO :new.spaceId
	FROM dual;
END;

/




