
/* Drop Triggers */

DROP TRIGGER TRI_LikeMovie_likeMovieNo;
DROP TRIGGER TRI_movie_movieNo;
DROP TRIGGER TRI_review_reviewNo;
DROP TRIGGER TRI_survey_surveyNo;
DROP TRIGGER TRI_vote_VoteNo;



/* Drop Tables */

DROP TABLE LikeMovie CASCADE CONSTRAINTS;
DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE vote CASCADE CONSTRAINTS;
DROP TABLE survey CASCADE CONSTRAINTS;
DROP TABLE members CASCADE CONSTRAINTS;
DROP TABLE movie CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_LikeMovie_likeMovieNo;
DROP SEQUENCE SEQ_movie_movieNo;
DROP SEQUENCE SEQ_review_reviewNo;
DROP SEQUENCE SEQ_survey_surveyNo;
DROP SEQUENCE SEQ_vote_VoteNo;




/* Create Sequences */

CREATE SEQUENCE SEQ_LikeMovie_likeMovieNo INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_movie_movieNo INCREMENT BY 1 START WITH 101;
CREATE SEQUENCE SEQ_review_reviewNo INCREMENT BY 1 START WITH 101;
CREATE SEQUENCE SEQ_survey_surveyNo INCREMENT BY 1 START WITH 101;
CREATE SEQUENCE SEQ_vote_VoteNo INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE LikeMovie
(
	likeMovieNo number NOT NULL,
	id varchar2(50) NOT NULL,
	movieNo number NOT NULL,
	PRIMARY KEY (likeMovieNo)
);


CREATE TABLE members
(
	id varchar2(50) NOT NULL,
	password varchar2(50) NOT NULL,
	name varchar2(50) NOT NULL,
	email varchar2(100) NOT NULL,
	gender varchar2(2) NOT NULL,
	joinDate date NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE movie
(
	movieNo number NOT NULL,
	movieName varchar2(100) NOT NULL,
	genre varchar2(20) NOT NULL,
	movieImg varchar2(200),
	startdate date NOT NULL,
	director varchar2(50) NOT NULL,
	actor1 varchar2(50),
	actor2 varchar2(50),
	actor3 varchar2(50),
	PRIMARY KEY (movieNo)
);


CREATE TABLE review
(
	reviewNo number NOT NULL,
	score number NOT NULL,
	content varchar2(3000) NOT NULL,
	regdate date DEFAULT SYSDATE NOT NULL,
	moddate date DEFAULT SYSDATE,
	movieNo number NOT NULL,
	id varchar2(50) NOT NULL,
	PRIMARY KEY (reviewNo)
);


CREATE TABLE survey
(
	surveyNo number NOT NULL,
	surveyTitle varchar2(100) NOT NULL,
	content1 varchar2(100) NOT NULL,
	onecnt number DEFAULT 0 NOT NULL,
	content2 varchar2(100) NOT NULL,
	twocnt number DEFAULT 0 NOT NULL,
	startNo date NOT NULL,
	endDate date NOT NULL,
	regdate date NOT NULL,
	moddate date,
	winnerid varchar2(50) NOT NULL,
	PRIMARY KEY (surveyNo)
);


CREATE TABLE vote
(
	VoteNo number NOT NULL,
	id varchar2(50) NOT NULL,
	surveyNo number NOT NULL,
	onetwo number NOT NULL,
	PRIMARY KEY (VoteNo)
);



/* Create Foreign Keys */

ALTER TABLE LikeMovie
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE review
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE survey
	ADD FOREIGN KEY (winnerid)
	REFERENCES members (id)
;


ALTER TABLE vote
	ADD FOREIGN KEY (id)
	REFERENCES members (id)
;


ALTER TABLE LikeMovie
	ADD FOREIGN KEY (movieNo)
	REFERENCES movie (movieNo)
;


ALTER TABLE review
	ADD FOREIGN KEY (movieNo)
	REFERENCES movie (movieNo)
;


ALTER TABLE vote
	ADD FOREIGN KEY (surveyNo)
	REFERENCES survey (surveyNo)
;



SELECT MOVIENO FROM MOVIE;

SELECT MOVIENO, MOVIENAME, SCORE, STARTDATE FROM  (
  SELECT MOVIENO, MOVIENAME, SCORE, STARTDATE
  FROM MOVIE
  ORDER BY SCORE DESC
 ) WHERE ROWNUM <= 10;

select surveyno from survey where enddate < SYSDATE 

SELECT MOVIENO, MOVIENAME, STARTDATE FROM MOVIE ORDER BY STARTDATE

DROP TABLE vote CASCADE CONSTRAINTS;
DROP TABLE survey CASCADE CONSTRAINTS;

CREATE TABLE survey
(
   surveyNo number NOT NULL,
   surveyTitle varchar2(100) NOT NULL,
   content1 varchar2(100) NOT NULL,
   onecnt number DEFAULT 0 NOT NULL,
   content2 varchar2(100) NOT NULL,
   twocnt number DEFAULT 0 NOT NULL,
   startDate date NOT NULL,
   endDate date NOT NULL,
   regdate date NOT NULL,
   moddate date,
   PRIMARY KEY (surveyNo)
);


CREATE TABLE vote  
(
   VoteNo number NOT NULL,
   id varchar2(50) NOT NULL,
   surveyNo number NOT NULL,
   onetwo number NOT NULL,
   voteDate DATE DEFAULT SYSDATE,
   PRIMARY KEY (VoteNo)
);

