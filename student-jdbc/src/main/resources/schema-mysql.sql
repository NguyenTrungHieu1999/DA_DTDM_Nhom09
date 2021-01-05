SET NAMES 'utf8';
CREATE TABLE IF NOT EXISTS student (
	Id VARCHAR(10) NOT NULL,
	FullName VARCHAR(100) NOT NULL,
	Gender varchar(5) NULL,
	Birthdate varchar(10) NULL,
	Address varchar(50) NULL,
	Phone varchar(10) NULL,
	IsDelete boolean,
	PRIMARY KEY (Id)
);

INSERT `student` VALUES ('17110299', 'Võ Trọng Hiếu', 'Nam', '1999-01-01', 'Tiền Giang', '0905847475', false);