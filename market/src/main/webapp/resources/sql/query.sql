CREATE TABLE board (
	num		NUMBER PRIMARY KEY,
	userid		VARCHAR2(20) NOT NULL
				REFERENCES member(USERID)
				ON DELETE CASCADE,
	subject		VARCHAR2(100) NOT NULL,
	content		VARCHAR2(4000) NOT NULL,
	reg_date	DATE DEFAULT SYSDATE,
	hit			NUMBER DEFAULT 0,
	IP			VARCHAR2(20)
);

INSERT INTO BOARD(num, userid, subject, content, ip) VALUES(SEQ_BOARD_NUM.NEXTVAL, ?, ?, ?, ?);

;

SELECT *
FROM (SELECT *
        FROM (SELECT * FROM board ORDER BY num desc)
        WHERE NUM <= 5 * 1 )
WHERE num <= 5 * (1 - 1)
ORDER BY num DESC;

SELECT * FROM ( SELECT * FROM board WHERE num <= 10
    ORDER BY num DESC ) WHERE ROWNUM <= 5;

DROP TABLE board;

1. 시퀀스 생성 board_seq

CREATE SEQUENCE SEQ_BOARD_NUM INCREMENT BY 1 START WITH 1;

SELECT NVL(hit, 0) + 1 FROM BOARD WHERE num = 2;

INSERT INTO BOARD VALUES(SEQ_BOARD_NUM.NEXTVAL, 'aaa', '두글', '리', SYSDATE, '1', '리');

DROP SEQUENCE SEQ_BOARD_NUM;

DROP SEQUENCE board_seq;

CREATE SEQUENCE board_seq NOCACHE;

2. BoardVO 생성
3. BoardDAO 생성 - 등록, 수정, 삭제, 조회, 전체 조회
4. BoardController 서블릿 생성

SELECT COUNT(*)
FROM board


CREATE TABLE product (
	pid			VARCHAR2(10) PRIMARY KEY,
	pname		VARCHAR2(30),
	price		NUMBER	DEFAULT 0,
	description VARCHAR2(4000),
	maker		VARCHAR2(30),
	category	VARCHAR2(20),
	stock		NUMBER	DEFAULT 0,
	condition	VARCHAR2(20),
	pimage		VARCHAR2(50)
);

DROP TABLE member;

INSERT INTO product VALUES('P1000', 'iPhone 6s', 800000, '1334X750 Renina HD display, 8-megapixel iSight Camera', 'Apple', 'Smart Phone', 1000, 'new', 'P1000.png');
INSERT INTO product VALUES('P1001', 'LG PC gram', 1500000, '3.3-inch,IPS LED display, 5rd Generation Intel Core processors', 'LG', 'Notebook', 1000, 'new', 'P1001.png');
INSERT INTO product VALUES('P1002', 'Galaxy Tab S', 900000, '3.3-inch, 212.8*125.6*6.6mm, Super AMOLED display, Octa-Core processor', 'Samsung', 'Tablet', 1000, 'new', 'P1002.png');

SELECT * FROM product ORDER BY pid;

CREATE TABLE member (
	userid		VARCHAR2(20 char) NOT NULL,
	userpw		VARCHAR2(20 char) NOT NULL,
	usernm		VARCHAR2(20 char) NOT NULL,
	email		VARCHAR2(50 char),
	photo		VARCHAR2(100),
	gender		CHAR(1 char),
	joinDate		DATE	DEFAULT SYSDATE
	,
	CONSTRAINT PK_MEMBER PRIMARY KEY (userid)
);


