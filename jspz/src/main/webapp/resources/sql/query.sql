CREATE TABLE tbl_board(
    bno NUMBER CONSTRAINT pk_tbl_board PRIMARY KEY,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    reg_date DATE DEFAULT SYSDATE,
    update_date DATE DEFAULT SYSDATE
)

CREATE SEQUENCE seq_tbl_board NOCACHE;

INSERT INTO tbl_board(bno, title, content, writer)
VALUES(seq_tbl_board.nextval, 'title', 'content', 'aaa');

SELECT * FROM tbl_board;
COMMIT;