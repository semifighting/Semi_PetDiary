-------------MEMBER

DROP TABLE MEMBER;
DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ;
CREATE TABLE MEMBER (
MEMBER_NO  NUMBER PRIMARY KEY ,
MEMBER_NAME    VARCHAR2(50)   NULL,
MEMBER_ID  VARCHAR2(100)  NULL,
MEMBER_PW  VARCHAR2(100)  NULL,
MEMBER_EMAIL   VARCHAR2(100)  NULL,
MEMBER_PHONE   VARCHAR2(20)   NULL,
MEMBER_ROLE    VARCHAR2(20)   NULL,
MEMBER_ADDRESS VARCHAR2(500)  NULL
);

select * from MEMBER
INSERT INTO MEMBER
VALUES(MEMBER_SEQ.NEXTVAL, '일반사원', 'employee', '123456', 'employee@a.com', '010-2222-2222', 'EMPLOYEE', '경기도 고양시 토당동');
----------------picture
DROP SEQUENCE PICTURE_NO_SEQ;
DROP TABLE PICTURE;
CREATE SEQUENCE PICTURE_NO_SEQ;
CREATE TABLE PICTURE(
	PICTURE_NO NUMBER PRIMARY KEY,
	PICTURE_NAME VARCHAR2(100) NOT NULL,
	PICTURE_DIRECTORY VARCHAR2(3000) NOT NULL,
	MEMBER_NO NUMBER NOT NULL,
	CONSTRAINT FK_PICTURE FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)
);

INSERT INTO PICTURE
VALUES (PICTURE_NO_SEQ.NEXTVAL, '첫번째 사진', '사진경로', 1);



---------------------calendar
DROP SEQUENCE CALENDAR_NO_SEQ;
DROP TABLE CALENDAR;
CREATE SEQUENCE CALENDAR_NO_SEQ;
CREATE TABLE CALENDAR(
	CALENDAR_NO NUMBER PRIMARY KEY,
	CALENDAR_STARTDATE DATE NOT NULL,
	CALENDAR_ENDDATE DATE NOT NULL,
	CALENDAR_NECESSITY VARCHAR2(500) NOT NULL,
	CALENDAR_ITEM VARCHAR2(500) NOT NULL,
	CALENDAR_TITLE VARCHAR2(500) NOT NULL,
	CALENDAR_CONTENT VARCHAR2(3000) NOT NULL,
	MEMBER_NO NUMBER NOT NULL,
	CONSTRAINT FK_CALENDAR FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)
);
INSERT INTO CALENDAR
VALUES (CALENDAR_NO_SEQ.NEXTVAL , TO_DATE('2021-04-16 15:30:00', 'yyyy-MM-dd HH24:MI:SS'), TO_DATE('2021-04-20 10:00:00', 'yyyy-MM-dd HH24:MI:SS'),
	'필수품', '화장/세면도구', '일정 제목', '일정 내용', 1);

	
----------------business table
DROP SEQUENCE BUSINESS_NUM;
DROP TABLE BUSINESS;
-- BUSINESS SEQUENCE 생성
CREATE SEQUENCE BUSINESS_NUM_SEQ;
-- BUSINESS TABLE 생성
CREATE TABLE BUSINESS(
	BUSINESS_NUM NUMBER PRIMARY KEY,
	BUSINESS_NAME VARCHAR2(100) NOT NULL,
	BUSINESS_ADDR VARCHAR2(500) NOT NULL,
	BUSINESS_ROLE VARCHAR2(2) NOT NULL,
	BUSINESS_TIME VARCHAR2(50) NOT NULL,
	BUSINESS_PARK VARCHAR2(2) NOT NULL,
	BUSINESS_BOOK VARCHAR2(2) NOT NULL,
	BUSINESS_ETC VARCHAR2(2000) NOT NULL,
	BUSINESS_NO NUMBER NOT NULL,
	MEMBER_NO NUMBER NOT NULL,
	
	CONSTRAINT BUSINESS_CK_ROLE CHECK (BUSINESS_ROLE IN ('H', 'S')),
	CONSTRAINT BUSINESS_CK_PARK CHECK (BUSINESS_PARK IN ('Y', 'N')),
	CONSTRAINT BUSINESS_CK_BOOK CHECK (BUSINESS_BOOK IN ('Y', 'N')),
	CONSTRAINT BUSINESS_FK_MN FOREIGN KEY (MEMBER_NO) REFERENCES MEMBER (MEMBER_NO)
);

SELECT * FROM BUSINESS
SELECT count(member_no) FROM MEMBER;



-- MENU
DROP TABLE MENU;

CREATE TABLE MENU(
	BUSINESS_NUM NUMBER PRIMARY KEY,
	MENU_PRICE VARCHAR2(50) NOT NULL,
	MENU_NAME VARCHAR2(50) NOT NULL,
	CONSTRAINT MENU_FK_MN FOREIGN KEY (BUSINESS_NUM) REFERENCES BUSINESS (BUSINESS_NUM)
);
-- INSERT BUSINESS
INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '도담동물병원', '경기도 고양시 토당동', 'H', '09:00 - 18:00', 'Y', 'Y', '도담 동물병원입니다. 내원을 희망하시면 연락 주세요', 20210416, 1);
SELECT * FROM BUSINESS;
INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '도담맛있는 식당', '경기도 고양시 토당동', 'S', '09:00 - 18:00', 'Y', 'Y', '도담 동물병원입니다. 내원을 희망하시면 연락 주세요', 20210416, 1);

--SELECT BUSINESS
SELECT * FROM BUSINESS;
	  	SELECT BUSINESS_NUM, BUSINESS_NAME, BUSINESS_ADDR,BUSINESS_ROLE, MEMBER_PHONE, BUSINESS_PARK
		FROM BUSINESS JOIN MEMBER USING(MEMBER_NO)
		WHERE BUSINESS_ROLE = 'S'
		ORDER BY BUSINESS_NUM DESC;
		
		SELECT BUSINESS_NUM, BUSINESS_NAME, BUSINESS_NO, BUSINESS_ADDR, BUSINESS_TIME, BUSINESS_ROLE 
   		FROM BUSINESS JOIN MEMBER USING(MEMBER_NO);
   		
   		
-- INSERT MENU
INSERT INTO MENU
VALUES(3, '5000원', '불고기버거세트');
SELECT * FROM MENU;
	
	
	


------------------------Diary
CREATE SEQUENCE DIARY_NO_SEQ;
CREATE TABLE DIARY(
	DIARY_NO NUMBER PRIMARY KEY NOT NULL,
	DIARY_TITLE VARCHAR2(200) NOT NULL,
	DIARY_CONTENT VARCHAR2(3000) NOT NULL,
	DIARY_REGDATE DATE,
	MEMBER_NO NUMBER(30) NOT NULL,
	CONSTRAINT FK_DIARY FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)		
);
INSERT INTO DIARY
VALUES(DIARY_NO_SEQ.NEXTVAL,'티코산책','산책산책',SYSDATE,1);
SELECT * FROM DIARY;


-------------------------PET

CREATE SEQUENCE PET_NO_SEQ;

select * from pet



CREATE TABLE PET(
	PET_NO NUMBER PRIMARY KEY,
	PET_SPECIES VARCHAR2(300) NOT NULL,
	PET_BREED VARCHAR2(300) NOT NULL,
	PET_NAME VARCHAR(150) NOT NULL,
	PET_BIRTHDAY DATE NOT NULL,
	PET_GENDER VARCHAR2(10) NOT NULL,
	MEMBER_NO NUMBER,
	CONSTRAINT FK_PET FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)
);
INSERT INTO PET
VALUES(PET_NO_SEQ.NEXTVAL,'강아지','말티푸','티코',TO_DATE('02-20-2020 11:11:11','MM-DD-YYYY HH24:MI:SS'),'F',1);
SELECT * FROM PET;

------------------------COMMUNITY TABLE
DROP TABLE COMMUNITY
DROP SEQUENCE COMMUNITY_SEQ_SEQ;
DROP SEQUENCE COMMUNITY_NO_SEQ;

CREATE SEQUENCE COMMUNITY_SEQ_SEQ;
CREATE SEQUENCE COMMUNITY_NO_SEQ;









------------------------COMMUNITY TABLE
DROP TABLE COMMUNITY
DROP SEQUENCE COMMUNITY_SEQ_SEQ;

CREATE SEQUENCE COMMUNITY_SEQ_SEQ;

CREATE TABLE COMMUNITY (
	COMMUNITY_SEQ NUMBER PRIMARY KEY,
	COMMUNITY_TITLE VARCHAR2(500) NOT NULL,
	COMMUNITY_CONTENT VARCHAR2(3000) NOT NULL,
	COMMUNITY_REGDATE DATE NOT NULL,
	COMMUNITY_REPORT VARCHAR2(2) CHECK(COMMUNITY_REPORT IN ('Y', 'N')),
	COMMUNITY_REPORTCOUNT NUMBER NOT NULL,
	COMMUNITY_REPORTCONTENT VARCHAR2(3000),
	COMMUNITY_NO NUMBER NOT NULL,
	COMMUNITY_COMMENT NUMBER NOT NULL,
	COMMUNITY_LIKE NUMBER,
	COMMUNITY_VIEWS NUMBER,
	MEMBER_NO NUMBER NOT NULL,
	CONSTRAINT COMMUNITY_FK FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)
)

INSERT INTO COMMUNITY VALUES(COMMUNITY_SEQ_SEQ.NEXTVAL, '시작', '시작', SYSDATE, 'N',0,COMMUNITY_NO_SEQ.NEXTVAL,0,1 )
SELECT * FROM COMMUNITY

INSERT INTO COMMUNITY VALUES(COMMUNITY_SEQ_SEQ.NEXTVAL, '시작', '시작', SYSDATE, 'Y',0,'신고내용',COMMUNITY_NO_SEQ.NEXTVAL,0,0,0,1 )


		SELECT COUNT(COMMUNITY_COMMENT) FROM COMMUNITY WHERE COMMUNITY_NO = 1



-- BOOK

DROP TABLE BOOK;
DROP SEQUENCE BOOK_NUM_SEQ;
--BOOK_NUM_SEQ SEQUENCE 생성
CREATE SEQUENCE BOOK_NUM_SEQ;
--book table 생성
CREATE TABLE BOOK(
  BOOK_NUM NUMBER PRIMARY KEY,
  BOOK_DATE VARCHAR2(20) NOT NULL,
  BOOK_TIME VARCHAR2(20) NOT NULL,
  BOOK_TYPE VARCHAR2(2) NOT NULL,
  BOOK_STORE NUMBER NOT NULL, --예약업체 번호(BUSINESS테이블 BUSINESS_NUM? )
  MEMBER_NO NUMBER NOT NULL,
  BOOK_PRICE NUMBER NOT NULL,
  BOOK_STATE VARCHAR2(2) NOT NULL,
  BOOK_HOSTIME VARCHAR2(20),
  CONSTRAINT BOOK_CK_TYPE CHECK (BOOK_TYPE IN ('H', 'S')),
  CONSTRAINT BOOK_CK_STATE CHECK(BOOK_STATE IN ('Y', 'N')),
  CONSTRAINT BOOK_FK_MN FOREIGN KEY (MEMBER_NO) REFERENCES MEMBER (MEMBER_NO)
);

<<<<<<< HEAD
<<<<<<< HEAD
=======
SELECT * FROM BOOK;










>>>>>>> kjk
=======

<<<<<<< HEAD
>>>>>>> ig
=======
>>>>>>> gwanwoo
