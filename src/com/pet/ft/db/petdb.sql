
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

SELECT * FROM CALENDAR
WHERE MEMBER_NO = 47;
	
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

SELECT count(member_no) FROM MEMBER;

-- MENU
DROP TABLE MENU;

CREATE TABLE MENU(
	BUSINESS_NUM NUMBER NOT NULL,
	MENU_PRICE VARCHAR2(50) NOT NULL,
	MENU_NAME VARCHAR2(50) NOT NULL,
	CONSTRAINT MENU_FK_MN FOREIGN KEY (BUSINESS_NUM) REFERENCES BUSINESS (BUSINESS_NUM)
);
-- INSERT BUSINESS
INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '도담동물병원', '경기도 고양시 토당동', 'H', '09:00 - 18:00', 'Y', 'Y', '도담 동물병원입니다. 내원을 희망하시면 연락 주세요', 20210416, 1);
SELECT * FROM BUSINESS;

--DELETE BUSINESS 'S'
DELETE FROM BUSINESS 
WHERE BUSINESS_ROLE = 'S';

-- INSERT BUSINESS 'S'
INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '나래 동물병원', '서울 광진구 능동로 283 진성빌딩', 'H', '09:00 - 18:00', 'Y', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20150831_87%2F1441019711632M6DzA_JPEG%2F11686553_0.jpg', 20210416, 1); 

-- INSERT MENU

INSERT INTO MENU VALUES(110, '5000원', '메뉴1');
INSERT INTO MENU VALUES(110, '5500원', '메뉴2');
INSERT INTO MENU VALUES(110, '5500원', '메뉴3');
INSERT INTO MENU VALUES(110, '5500원', '메뉴4');
INSERT INTO MENU VALUES(111, '5000원', '메뉴1');
INSERT INTO MENU VALUES(111, '5500원', '메뉴2');
INSERT INTO MENU VALUES(111, '5500원', '메뉴3');
INSERT INTO MENU VALUES(111, '5500원', '메뉴4');
INSERT INTO MENU VALUES(112, '5000원', '메뉴1');
INSERT INTO MENU VALUES(112, '5500원', '메뉴2');
INSERT INTO MENU VALUES(112, '5500원', '메뉴3');
INSERT INTO MENU VALUES(112, '5500원', '메뉴4');
SELECT * FROM MENU;
SELECT * FROM BUSINESS;
WHERE BUSINESS_ROLE = 'S';

SELECT DISTINCT(BUSINESS_NUM) BUSINESS_NUM, BUSINESS_NAME, BUSINESS_ADDR, BUSINESS_ROLE, MEMBER_PHONE, BUSINESS_PARK, BUSINESS_ETC, BUSINESS_BOOK, MENU_PRICE,	MENU_NAME
FROM BUSINESS JOIN MEMBER USING(MEMBER_NO) JOIN MENU USING(BUSINESS_NUM);

SELECT DISTINCT *
FROM MENU
WHERE BUSINESS_NUM = 110;
	
	SELECT BUSINESS_NUM, BUSINESS_NAME, BUSINESS_ADDR, BUSINESS_ROLE, MEMBER_PHONE, BUSINESS_PARK, BUSINESS_ETC, BUSINESS_BOOK
					FROM BUSINESS JOIN MEMBER USING(MEMBER_NO)
					WHERE BUSINESS_ROLE = 'S';
	
select * from book;

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


SELECT E.RNUM, E.BOOK_NUM, E.MEMBER_NAME, E.BUSINESS_NAME, E.BOOK_DATE, E.BOOK_TIME
		FROM(
			SELECT ROWNUM AS RNUM, D.BOOK_NUM, D.MEMBER_NAME, D.BUSINESS_NAME, D.BOOK_DATE, D.BOOK_TIME
			FROM(
				SELECT A.BOOK_NUM, B.MEMBER_NAME, C.BUSINESS_NAME, A.BOOK_DATE, A.BOOK_TIME
				FROM BOOK A JOIN MEMBER B 
				ON A.MEMBER_NO = B.MEMBER_NO 
				JOIN BUSINESS C
				ON A.BUSINESS_NUM = C.BUSINESS_NUM
				WHERE BOOK_TYPE = 'S'
				ORDER BY A.BOOK_NUM
			) D
			WHERE ROWNUM <= 5) E
		WHERE E.RNUM > 0

		select * from business;
		
-------------------------PET

CREATE SEQUENCE PET_NO_SEQ;

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
CREATE SEQUENCE COMMUNITY_SEQ_SEQ;
DELETE FROM COMMUNITY
CREATE TABLE COMMUNITY (
	COMMUNITY_SEQ NUMBER PRIMARY KEY,
	COMMUNITY_TITLE VARCHAR2(500) NOT NULL,
	COMMUNITY_CONTENT VARCHAR2(4000) NOT NULL,
	COMMUNITY_REGDATE DATE NOT NULL,
	COMMUNITY_REPORT VARCHAR2(2) CHECK(COMMUNITY_REPORT IN ('Y', 'N')),
	COMMUNITY_REPORTCOUNT NUMBER NOT NULL,
	COMMUNITY_REPORTCONTENT VARCHAR2(1000),
	COMMUNITY_NO NUMBER NOT NULL,
	COMMUNITY_COMMENT NUMBER NOT NULL,
	MEMBER_NO NUMBER NOT NULL,
	CONSTRAINT COMMUNITY_FK FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)
)

-- BOOK

DROP TABLE BOOK;
DROP SEQUENCE BOOK_NUM_SEQ;
--BOOK_NUM_SEQ SEQUENCE 생성
CREATE SEQUENCE BOOK_NUM_SEQ;
--book table 생성
CREATE TABLE BOOK(
  BOOK_NUM NUMBER PRIMARY KEY,
  BOOK_DATE VARCHAR2(20) NOT NULL,
  BOOK_TIME VARCHAR2(20) ,
  BOOK_TYPE VARCHAR2(2) NOT NULL,
  BUSINESS_NUM NUMBER NOT NULL, --예약업체 번호(BUSINESS테이블 BUSINESS_NUM? )
  MEMBER_NO NUMBER NOT NULL,
  BOOK_PRICE NUMBER,
  BOOK_STATE VARCHAR2(2) ,
  BOOK_HOSTIME VARCHAR2(20),
  BOOK_COUNSEL VARCHAR2(20),
  BOOK_HOSTIME VARCHAR2(20)
  BOOK_COUNSEL VARCHAR2(20),
  CONSTRAINT BOOK_CK_TYPE CHECK (BOOK_TYPE IN ('H', 'S')),
  CONSTRAINT BOOK_CK_STATE CHECK(BOOK_STATE IN ('Y', 'N')),
  CONSTRAINT BOOK_FK_MN FOREIGN KEY (MEMBER_NO) REFERENCES MEMBER (MEMBER_NO),
  CONSTRAINT BOOK_FK_BN FOREIGN KEY (BUSINESS_NUM) REFERENCES BUSINESS(BUSINESS_NUM) --빠져있었음 
);

CHECK TABLE BOOK;
----컬럼 데이터타입 확인용
SELECT COLUMN_NAME, NULLABLE

FROM ALL_TAB_COLUMNS

WHERE TABLE_NAME = 'BOOK';
select * from book

-------RTC
CREATE SEQUENCE RTC_NO_SEQ;
DROP TABLE RTC
CREATE TABLE RTC(
	RTC_ROOM VARCHAR2(1000) NOT NULL,
	RTC_USE VARCHAR2(2) NOT NULL,
	MEMBER_NO NUMBER NOT NULL,
	BUSINESS_NUM NUMBER NOT NULL,
	CONSTRAINT RTC_MEBER_FK FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO),
	CONSTRAINT RTC_BUSINESS_FK FOREIGN KEY(BUSINESS_NUM) REFERENCES BUSINESS(BUSINESS_NUM)
)
select * from member
UPDATE BUSINESS SET BUSINESS_BOOK='Y'  WHERE BUSINESS_NUM = 81
update book set book_date = '20210503', member_no = 56 where book_num = 68

DROP TABLE LIKES
CREATE TABLE LIKES(
	MEMBER_NO NUMBER NOT NULL,
	COMMUNITY_SEQ NUMBER NOT NULL,
	CONSTRAINT LIKE_MEBER_FK FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO),
	CONSTRAINT LIKE_COMMUNITY_SEQ FOREIGN KEY(COMMUNITY_SEQ) REFERENCES COMMUNITY(COMMUNITY_SEQ)
	
	)

SELECT COUNT(*) FROM ORDERINFO WHERE MEMBER_NO = #{MEMBER_NO}
=======
------
--식당 데이터 추가

SELECT business_etc FROM BUSINESS;

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '바잇미', '서울 강남구 논현로175길 101-3 1층', 'S', '12:00 - 21:00', 'N', 'N', 'https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsoong_vely%2F221504138714&psig=AOvVaw2L1JWLmoFuhMN8gG-zxLEH&ust=1620198010706000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOjEuIu6r_ACFQAAAAAdAAAAABAD', 20210504, 58);

UPDATE BUSINESS
SET BUSINESS_ETC = 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA2MjNfMTg5%2FMDAxNTkyODM5NTMyMjkz.G3XSDM9I7ZFu1hVMey0sKOuZI3oz8TihnQlbzX7wZGMg.OlblgNilPwz1Okr_INqFtdVmjR2ZXT4kmpUe2iQlBPQg.JPEG.molly4595%2FIMG_5598.jpg'
WHERE BUSINESS_NAME = '바잇미';
INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '러스티', '서울 강남구 선릉로158길 14-1', 'S', '12:00 - 21:00', 'Y', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20180324_294%2F1521882008300mgqJ0_JPEG%2FfrhaG0Q2ScDrqnW9MRrERVqt.JPG.jpg', 20210505, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '카페아망', '서울 서초구 강남대로89길 8', 'S', '10:00 - 23:00', 'N', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA5MTlfMjkg%2FMDAxNjAwNDc0ODU4MDMy.Fjy5XUG5ixkemy-GpwJiY5qsjLvEjFGEXMMaYgGu9uIg.7WYs_ozmpc5-V52ZYmINAf8K2zUMolz5Y76z3ImnRoUg.JPEG.thsqkfcjdruf%2F1600474855095.jpg', 20210506, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '까사밀', '서울 강남구 도산대로1길 83 라까사호텔', 'S', '11:30 - 15:00', 'Y', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAzMTdfOTEg%2FMDAxNjE1OTYzNTE5MTkz.-bUl2UCxAvWN83i9pdywDqur_CewbutGKrAM5iOMxA0g.eGy_oGUl2Sqm33G1Pf32fctxl8HWEmj5QN7RfBxkrGog.JPEG.lovedudk12%2Foutput_1217472620.jpg', 20210503, 58); 

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '쿠스퀘어', '서울 강남구 언주로130길 13', 'S', '09:00 - 00:00', 'Y', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEwMjRfODUg%2FMDAxNjAzNDY3MTc4OTMz.GxDQ22IYVY9qGeU941ihkito05wZbh10Dwpk7fLEqx4g.yWQ15lwpSlYqs5Qiqienu_S5L9EXlHP8C2Bc_-1yc68g.JPEG.bbongho357%2F20201022_125755.jpg', 20210502, 58);  

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '어라운드데이', '서울 성동구 서울숲2길 24-1', 'S', '12:00 - 21:00', 'N', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEwMThfMTUy%2FMDAxNjAzMDIzMTI2OTc3.nEum69M1lIYCLWPaio9wDVWVb-0R6UWT1k6_e2VQW0kg.Zgat509V1yxRAKw2NeajHzw3oCoTwyaCxLWnxhXe7vog.JPEG.yjezzang%2F1603023128121.jpg', 20210501, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, 'DONO', '서울 용산구 이태원로54길 63', 'S', '12:00 - 22:00', 'N', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDAzMzFfMzEg%2FMDAxNTg1NjUzMDQ5MTg2.HD2aayUmJ8QRBVIM7yGU263vl07tnktG79tVpuOB7l0g.8W8YutetzszE1TzoVTqs1N2zSGN1S0s4fxILwwCNrAcg.JPEG.best8555%2F1585653048050.jpg', 20210430, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '쟈크풀러', '서울 용산구 이태원로 228-1', 'S', '11:30 - 17:00', 'N', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA4MTBfMTcw%2FMDAxNTk3MDM2NjMzNTY3.94zAlvyXRW6BGzJ72xnH9ZrHSmUoryOb8bj1TyWl52Mg.2iVJq-j0tLY2meFtiqusvtq0ugmLrKM_aUOk3pLL0hEg.JPEG.wjstjddk1112%2FIMG_7632.jpg', 20210429, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '카페드블루 블루스퀘어점', '서울 용산구 한남동 727-35 카페드블루', 'S', '11:30 - 17:00', 'N', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20201205_188%2F1607147823578QJExC_JPEG%2FK4wR3wuGHPPIGaluIsrBHEz4.jpg', 20210428, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '안티 스트레스', '서울 용산구 이태원로20가길 9-7 2층', 'S', '12:30 - 22:00', 'N', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAyMTlfMjc1%2FMDAxNjEzNzM2OTIzNzEx.K9Y1Ih60I-Sy_SUmxkokJBlUYrmOBudnqmNJ6X-Lm2sg.9Dd4rfHD1s9iFhu0iGP-XuxVA4jZeZo_3P6OsWKcowgg.JPEG.jungah0127%2FKakaoTalk_20210219_192644037.jpg', 20210427, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '쁘띠베네', '서울 용산구 이태원로20길 2-12', 'S', '10:00 - 21:00', 'N', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTEyMTRfOSAg%2FMDAxNTc2Mjk5MjQwNTE2.vUq44z9kqErJkjBAi0BU1Q5X432l--vHaAs9HAQ57nQg.voDpvbKyRo5XIt-e4QJVagLNk4eaIkF6hRZoRW9d2dIg.JPEG.gardening_sg%2F1576299238926.jpg', 20210426, 58);


INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '1989 비스트로', '서울 용산구 회나무로13가길 37 1층 1989 비스트로', 'S', '12:00 - 21:00', 'Y', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMDFfMjgy%2FMDAxNjA5NDM0NjM0Nzgy.Z4mH3FYo33-PY-D3oC5F349CN-OZl8gaY8k4EMLxhz8g.nmd8VRDDCtRz_IavhiVGOwgoGCW-CLpIfLKlGSy_hCcg.JPEG.nagazaapp%2F%25B4%25D9%25BF%25EE%25B7%25CE%25B5%25E5_%25282%2529.jpg', 20210425, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '머치커피', '서울 동작구 동작대로9길 43 1층', 'S', '12:00 - 21:00', 'N', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAzMDVfMjk2%2FMDAxNjE0ODczMTUyNDM1.6i02PsN-L4P5HXv_VquIsvPwyMqCC-lg2hTdMRKQfBEg.fZPcV3WheexeH7g_kwmehPkp1AsnXLHXXR6nlFmwymQg.JPEG.vmeeo%2FIMG_9047.jpg', 20210424, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '카페 도킹', '서울 서초구 동산로19길 54', 'S', '09:00 - 23:00', 'Y', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MDZfNzUg%2FMDAxNjE3NzAzOTA2Nzk5.F6ULVsJTOEF1QLgjp65psUsuIGpTgQFbk2rGtyzTbcAg.OK4uIYSWKjWYa6wm-tMjOFbWunonjKYUTlyyGMfX4w8g.JPEG.jaey0226%2FIMG_7068.jpg', 20210423, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '스태픽스', '서울 종로구 사직로9길 22 102호', 'S', '10:00 - 21:00', 'Y', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MjlfMzAw%2FMDAxNjE5NjcxMzAxODE3.Yq21385B60HdJVcopGrf-8BAlh1dTEguGeJmoPle1asg.Ugqm6hi2AKwyJgQkpOUqGXO0LQM_VOho-GgdoI6YY-gg.JPEG.hhyuna_k%2FB6B537CE-D5D2-40D6-9C28-0E0D04E4E72F.jpg', 20210422, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '퍼피커피', '서울 성동구 무학로 24-1 1층', 'S', '11:00 - 22:00', 'N', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAyMDdfNzEg%2FMDAxNjEyNjI2MTk4NTA5.cAJWzt77BGVwenNmKPu1Cr9eS7OpycQEq0gpJ1cbv34g.N7ONs4zvQXCGHb3al824wzVceMEbfgd4YIzHf6MvtZog.JPEG.pjy3597%2F1.jpg', 20210421, 58);


INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '타이밍 LP music bar', '서울 서초구 양재천로 135-4 솔빌딩 1층', 'S', '19:00 - 02:00', 'Y', 'Y', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODAxMjhfMTM1%2FMDAxNTE3MTE3MTA5NTkz.2lRXPoo4oJuknWu-7rugKZyheLcG9MedevCxSb3jcPcg.-CYI0W3_dP3IOSKwZhK4WLxzdDEF6TDJRWKnvlwgODEg.JPEG.syol07%2F%25BC%25D2%25BF%25AC%25C0%25CC%25C0%25D7_DSC_0148.JPG', 20210420, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '오뗄드니엔테', '서울 송파구 백제고분로45길 4-21', 'S', '12:00 - 22:00', 'N', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MDlfMTg2%2FMDAxNjE3OTczNzYzODk3.BsG3dklzvZClek-1DLmka4dDWFmaTMqWD84DwZ5IPqsg.6KEwDYy8Ykp0tbvU1X1nnjwvXjQ-odKQV4h75KroJswg.JPEG.lycossue%2FIMG_8283.jpg', 20210419, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '라딧프로젝트', '서울 송파구 송파대로 450 1층', 'S', '13:00 - 22:00', 'N', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MDZfMjg3%2FMDAxNjE3NjkwNzkwMzUx.rvd1WLkNrLdqnRLW3CIjXGdKhokAE5tsmPiNnutqVpAg.x3NeMARkMtt-w57eicI8ZxIkymdRTn6VT6tuSUUpoUYg.JPEG.ddanguri012%2F20210404_133013.jpg', 20210418, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, '카페 아임히어', '서울 용산구 백범로 326 1층', 'S', '13:00 - 22:00', 'N', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA5MDlfNDIg%2FMDAxNTk5NjM3MzYzNTgz.YcQON9ztjSSA_5N-akvsTnhf4KuHSw5Q-uLentzHFAAg.pha_ZRLZw5BwnwSPcq8TttzTr7uJwTIo5QfOtYlXnSMg.JPEG.ghkahrdh%2F1599637362446.jpg', 20210417, 58);

INSERT INTO BUSINESS
VALUES(BUSINESS_NUM_SEQ.NEXTVAL, 'hundred11', '서울 서초구 서초대로 3-4 방배디오슈페리움 지하 1층', 'S', '13:00 - 22:00', 'Y', 'N', 'https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA5MTdfMTU1%2FMDAxNTM3MTc4OTU3OTAw.UTwC4lW6onXTTZIxFzocphChXGVSJ5NV3UrXAqUiOd4g.t4_bUkf9MyYc0hv_2WuILr7agPieZZCRogkgnJGzPbcg.JPEG.armdaunai%2F1537178020864.jpg', 20210416, 58);

--여행일정저장 테이블
CREATE SEQUENCE TRAVEL_NO_SEQ;
CREATE TABLE TRAVEL(
	TRAVEL_NO NUMBER PRIMARY KEY NOT NULL,
	TRAVEL_NAME VARCHAR2(100)NOT NULL,
	TRAVEL_DATE VARCHAR2(100),
	TRAVEL_SPOT1 VARCHAR2(50),
	TRAVEL_SPOT2 VARCHAR2(50),
	TRAVEL_SPOT3 VARCHAR2(50),
	TRAVEL_TIME1 NUMBER(30),
	TRAVEL_TIME2 NUMBER(30),
	TRAVEL_STAY1 NUMBER(30),
	TRAVEL_STAY2 NUMBER(30),
	MEMBER_NO NUMBER(30) NOT NULL,
	CONSTRAINT FK_TRAVEL FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(MEMBER_NO)	
);
INSERT INTO TRAVEL
VALUES(TRAVEL_NO_SEQ.NEXTVAL,'제주여행','20210603','제주국제공항','애월','한담해안산책로',30,10,10,30,1);

SELECT * FROM TRAVEL;


