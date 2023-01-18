SELECT * FROM book;
SELECT * FROM book ORDER BY bookid;
SELECT * FROM book WHERE bookid = 1;

--회원정보 테이블
CREATE TABLE t_member(
	id	VARCHAR2(20)	PRIMARY KEY,
	pw	VARCHAR2(20)	NOT NULL,
	name VARCHAR2(20)	NOT NULL,
	email VARCHAR2(50),
	photo VARCHAR2(100),
	gender CHAR(1),
	joinDate DATE DEFAULT SYSDATE
	);
	
	SELECT * FROM t_member WHERE id='admin' AND pw='1111';
	
UPDATE T_MEMBER SET pw='1234' where id = 'admin';
SELECT * from T_MEMBER;
