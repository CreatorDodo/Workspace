
/* Drop Tables */

DROP TABLE T_VOTE CASCADE CONSTRAINTS;
DROP TABLE T_SURVEY CASCADE CONSTRAINTS;
DROP TABLE MADANG.T_MEMBER CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_T_SURVEY_SURVEY_NO;




/* Create Sequences */

CREATE SEQUENCE SEQ_T_SURVEY_SURVEY_NO INCREMENT BY 1 START WITH 1;



/* Create Tables */



CREATE TABLE T_SURVEY
(
	SURVEY_NO number NOT NULL,
	TITLE varchar2(100),
	ONE varchar2(200),
	ONE_CNT number DEFAULT 0,
	TWO varchar2(200),
	TWO_CNT number DEFAULT 0,
	START_DATE date,
	END_DATE date,
	REG_DATE date DEFAULT SYSDATE,
	MOD_DATE date,
	PRIMARY KEY (SURVEY_NO)
);


CREATE TABLE T_VOTE
(
	SURVEY_NO number NOT NULL,
	ID varchar2(20 char) NOT NULL,
	ONE_TWO varchar2(200),
	VOTE_DATE date
);


CREATE TABLE MADANG.T_MEMBER
(
	ID varchar2(20 char) NOT NULL,
	PW varchar2(20 char) NOT NULL,
	NAME varchar2(20 char) NOT NULL,
	EMAIL varchar2(50 char),
	PHOTO varchar2(100 char),
	GENDER char(1 char),
	JOINDATE date DEFAULT SYSDATE
	,
	CONSTRAINT SYS_C007025 PRIMARY KEY (ID)
);



/* Create Foreign Keys */

ALTER TABLE T_VOTE
	ADD FOREIGN KEY (SURVEY_NO)
	REFERENCES T_SURVEY (SURVEY_NO)
;


ALTER TABLE T_VOTE
	ADD FOREIGN KEY (ID)
	REFERENCES MADANG.T_MEMBER (ID)
;



SELECT survey_no, title, one_cnt, two_cnt,
TO_CHAR(start_date, 'yyyy.mm.dd') AS start_date, TO_CHAR(end_date+6, 'yyyy.mm.dd') end_date
FROM t_survey
ORDER BY start_date DESC;


SELECT survey_no
FROM t_survey
WHERE TO_DATE(20101010, 'yyyy.mm.dd') between start_date AND end_date;