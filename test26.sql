/*
CREATE TABLE music_genre2(
  no NUMBER,
  genre VARCHAR2(20) CONSTRAINT mg2_genre_nn NOT NULL,
  CONSTRAINT mg2_no_pk PRIMARY KEY(no)
);



CREATE TABLE music2(
       mno NUMBER,
       cateno NUMBER,
       title VARCHAR2(300) CONSTRAINT music2_title_nn NOT NULL,
       poster VARCHAR2(260) CONSTRAINT musi2c_poster_nn NOT NULL,
       singer VARCHAR2(100) CONSTRAINT music2_singer_nn NOT NULL,
       album VARCHAR2(260) CONSTRAINT music2_album_nn NOT NULL,
       CONSTRAINT music2_mno_pk PRIMARY KEY(mno),
       CONSTRAINT music2_cateno_fk FOREIGN KEY(cateno)
       REFERENCES music_genre2(no)
);

-- 가요 POP OST 트롯 EDM JAZZ
INSERT INTO music_genre2 VALUES(1, '발라드');
INSERT INTO music_genre2 VALUES(2, '댄스');
INSERT INTO music_genre2 VALUES(3, '랩/힙합');
INSERT INTO music_genre2 VALUES(4, 'RnB/Soul');
INSERT INTO music_genre2 VALUES(5, '인디음악');
INSERT INTO music_genre2 VALUES(6, '록/메탈');
INSERT INTO music_genre2 VALUES(7, '트로트');
INSERT INTO music_genre2 VALUES(8, '포크/블루스');
COMMIT;



--mno가 자동 증가
CREATE SEQUENCE music2_mno_seq
	START WITH 1
	INCREMENT BY 1
	NOCYCLE
	NOCACHE;
*/
