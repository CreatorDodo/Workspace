
/* Drop Tables */

DROP TABLE NEW_ORDER CASCADE CONSTRAINTS;
DROP TABLE NEW_BOOK CASCADE CONSTRAINTS;
DROP TABLE NEW_CUSTOMER CASCADE CONSTRAINTS;
DROP TABLE NEW_PUBLISHER CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE NEW_BOOK
(
	bookid number NOT NULL,
	bookname varchar2(50),
	price number,
	pubname varchar2(50) NOT NULL,
	PRIMARY KEY (bookid)
);


CREATE TABLE NEW_CUSTOMER
(
	custid number NOT NULL,
	name varchar2(20),
	address varchar2(50),
	phone varchar2(20),
	PRIMARY KEY (custid)
);


CREATE TABLE NEW_ORDER
(
	orderid number NOT NULL,
	bookid number NOT NULL,
	custid number NOT NULL,
	orderDate date,
	saleprice number,
	PRIMARY KEY (orderid)
);


CREATE TABLE NEW_PUBLISHER
(
	pubname varchar2(50) NOT NULL,
	stname varchar2(20),
	officePhone varchar2(20),
	PRIMARY KEY (pubname)
);



/* Create Foreign Keys */

ALTER TABLE NEW_ORDER
	ADD FOREIGN KEY (bookid)
	REFERENCES NEW_BOOK (bookid)
;


ALTER TABLE NEW_ORDER
	ADD FOREIGN KEY (custid)
	REFERENCES NEW_CUSTOMER (custid)
;




ALTER TABLE NEW_BOOK
	ADD CONSTRAINT FK_NEWBOOK_PUB FOREIGN KEY (pubname)
	REFERENCES NEW_PUBLISHER (pubname)
	ON DELETE CASCADE
;



