-- 1-1
CREATE TABLE book_tbl_06(
    book_no NUMBER PRIMARY KEY,
    book_name VARCHAR2(50) NOT NULL,
    book_coverimg VARCHAR2(20),
    book_date DATE,
    book_price NUMBER,
    book_publisher VARCHAR2(50),
    book_info VARCHAR2(2000)
);

-- 1-2
INSERT INTO book_tbl_06 (book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (100, '리눅스', '100.jpg', TO_DATE('15/09/02', 'RR/MM/DD'), 24000, '나룩스', '운영체제, DB기초, 네트워크기초, 개발환경구축');

INSERT INTO book_tbl_06 (book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (101, '자바', '101.jpg', TO_DATE('16/01/10', 'RR/MM/DD'), 20000, '이자바', '프로그래밍 언어');

INSERT INTO book_tbl_06 (book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (102, '자바웹프로그래밍', '102.jpg', TO_DATE('16/10/30', 'RR/MM/DD'), 25000, '김프로', '개발환경/서버프로그램/배치프로그램');

INSERT INTO book_tbl_06 (book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (103, '오픈소스활용하기', '103.jpg', TO_DATE('17/09/01', 'RR/MM/DD'), 30000, '박오픈', '형상관리, 빌드, 배포');

INSERT INTO book_tbl_06 (book_no, book_name, book_coverimg, book_date, book_price, book_publisher, book_info)
VALUES (104, 'HTML', '104.jpg', TO_DATE('18/04/04', 'RR/MM/DD'), 10000, '홍길동', 'HTML/CSS/JAVASCRIPT/JQUERY');

-- 1-3
CREATE TABLE rent_tbl_06(
    rent_no NUMBER PRIMARY KEY,
    book_no NUMBER NOT NULL,
    rent_price NUMBER NOT NULL,
    rent_date DATE NOT NULL,
    rent_status CHAR(1) DEFAULT 0 NOT NULL
);

-- 1-4
INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10001, 100, 2400, TO_DATE('18/07/02', 'RR/MM/DD'), 1);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10002, 101, 2000, TO_DATE('18/07/04', 'RR/MM/DD'), 1);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10003, 100, 2400, TO_DATE('18/08/02', 'RR/MM/DD'), 1);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10004, 100, 2400, TO_DATE('18/08/12', 'RR/MM/DD'), 1);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10005, 102, 2500, TO_DATE('18/08/13', 'RR/MM/DD'), 1);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10006, 103, 3000, TO_DATE('18/08/13', 'RR/MM/DD'), 1);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10007, 103, 3000, TO_DATE('18/08/20', 'RR/MM/DD'), 0);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10008, 103, 2400, TO_DATE('18/09/03', 'RR/MM/DD'), 1);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10009, 100, 2400, TO_DATE('18/09/08', 'RR/MM/DD'), 1);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10010, 100, 2400, TO_DATE('18/09/14', 'RR/MM/DD'), 0);

INSERT INTO rent_tbl_06(rent_no, book_no, rent_price, rent_date, rent_status)
VALUES (10011, 102, 2500, TO_DATE('18/09/14', 'RR/MM/DD'), 0);
