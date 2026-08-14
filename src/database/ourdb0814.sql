CREATE DATABASE ourdb0814;
USE ourdb0814;
CREATE TABLE patient( 
    pno int AUTO_INCREMENT , 
    pname VARCHAR(10) ,
    pphone VARCHAR(20) ,
    constraint PRIMARY KEY( pno ) 
);


CREATE TABLE doctor( 
    dno int AUTO_INCREMENT , 
    dname VARCHAR(10) ,
    dphone VARCHAR(20),
    dpart VARCHAR(10) ,
    constraint PRIMARY KEY( dno ) 
);

CREATE TABLE book (
    bno INT AUTO_INCREMENT,
    bdate DATE NOT NULL,
    dno INT,                   
    pno INT, 
    
    CONSTRAINT PRIMARY KEY(bno),
        CONSTRAINT FOREIGN KEY(dno) REFERENCES doctor(dno) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY(pno) REFERENCES patient(pno) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO patient(pname, pphone) VALUES
('홍길동', '010-1111-2222'),
('김철수', '010-3333-4444'),
('김영희', '010-5555-6666'),
('이민수', '010-1112-3333'),
('박지민', '010-2223-4444'),
('최수진', '010-3334-5555'),
('정현우', '010-4445-6666'),
('강민지', '010-5556-7777'),
('윤서준', '010-6667-8888'),
('한지우', '010-7778-9999');

INSERT INTO doctor(dname, dphone, dpart) VALUES
('김정수', '010-7777-8888', '소아과'),
('이지호', '010-9999-0000', '정형외과'),
('박소희', '010-1234-5678', '내과'),
('최민호', '010-2345-6789', '외과'),
('정수빈', '010-3456-7890', '피부과'),
('강현수', '010-4567-8901', '안과'),
('윤지영', '010-5678-9012', '치과'),
('한성민', '010-6789-0123', '신경과'),
('오세진', '010-7890-1234', '이비인후과'),
('임유진', '010-8901-2345', '산부인과');

INSERT INTO book(bdate, dno, pno) VALUES
('2026-01-14', 1, 1),
('2025-01-14', 1, 2),
('2026-08-14', 3, 2),
('2026-08-15', 2, 3),
('2026-08-16', 4, 4),
('2026-08-17', 5, 5),
('2026-08-18', 6, 6),
('2026-08-19', 7, 7),
('2026-08-20', 8, 8),
('2026-08-21', 10, 9);