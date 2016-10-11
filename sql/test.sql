DROP TABLE book;
DROP TABLE cart;
DROP TABLE category;
DROP TABLE MEMBER;
DROP TABLE orders;
DROP TABLE ordersbook;

update book set TITLE =2, PRICE=2,  CATEGORY_NO=1 WHERE NO=3;
select * FROM CATEGORY;

UPDATE CATEGORY SET NO=2 WHERE NO=1;
select * FROM book;
select CATEGORY_SEQ;
alter SEQUENCE CATEGORY_SEQ start with 99;


-- 커맨드창에 
-- @파일이름
-- 쓰면 한번에 실행
