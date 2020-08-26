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

-- ���� POP OST Ʈ�� EDM JAZZ
INSERT INTO music_genre2 VALUES(1, '�߶��');
INSERT INTO music_genre2 VALUES(2, '��');
INSERT INTO music_genre2 VALUES(3, '��/����');
INSERT INTO music_genre2 VALUES(4, 'RnB/Soul');
INSERT INTO music_genre2 VALUES(5, '�ε�����');
INSERT INTO music_genre2 VALUES(6, '��/��Ż');
INSERT INTO music_genre2 VALUES(7, 'Ʈ��Ʈ');
INSERT INTO music_genre2 VALUES(8, '��ũ/��罺');
COMMIT;



--mno�� �ڵ� ����
CREATE SEQUENCE music2_mno_seq
	START WITH 1
	INCREMENT BY 1
	NOCYCLE
	NOCACHE;
*/
