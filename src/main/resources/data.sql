INSERT INTO USER (ID, NAME, EMAIL, ROLE) VALUES (1, 'Samuel', 'sam@opec.com', 'user,network');
INSERT INTO USER (ID, NAME, EMAIL, ROLE) VALUES (2, 'Roger', 'roger@stargroup.com', 'user');
INSERT INTO USER (ID, NAME, EMAIL, ROLE) VALUES (3, 'Sid', 'sid@gmail.com', 'user');
INSERT INTO USER (ID, NAME, EMAIL, ROLE) VALUES (4, 'Tammy', 'tammy@gmail.com', 'user');

INSERT INTO BOOK (ID, NAME, AUTHOR, ISBN) VALUES (1, 'Harry Porter 1', 'JK Rowling', '987316');
INSERT INTO BOOK (ID, NAME, AUTHOR, ISBN) VALUES (2, 'Harry Porter 2', 'JK Rowling', '672345');
INSERT INTO BOOK (ID, NAME, AUTHOR, ISBN) VALUES (3, 'Lord of the Rings', 'JR TOKIEN', '712312');



--Samuel reserve Harry Porter 1
--INSERT INTO RESERVATION (BOOK_ID, USER_ID) VALUES (1, 1);
--Samuel reserve Harry Porter 2
--INSERT INTO RESERVATION (BOOK_ID, USER_ID) VALUES (2, 1);

--INSERT INTO ISSUE (ACCT_NO, NAME, DATE_ISSUE, TIME_ISSUE, DATE_RETURN, TIME_RETURN, REG_NO) VALUES (001, 'Samuel', '30:03:2020', '11:30','10:04:2020,'11:00','12326');
--INSERT INTO ISSUE (ACCT_NO, NAME, DATE_ISSUE, TIME_ISSUE, DATE_RETURN, TIME_RETURN, REG_NO) VALUES (002, 'Sid', '30:03:2020', '11:30','10:04:2020,'11:00','12327');
--INSERT INTO ISSUE (ACCT_NO, NAME, DATE_ISSUE, TIME_ISSUE, DATE_RETURN, TIME_RETURN, REG_NO) VALUES (003, 'Tammy', '30:03:2020', '11:30','10:04:2020,'11:00','12328');
--
--INSERT INTO RETURN (REG_NO, NAME, DATE_RETURN, TIME_RETURN, DATE_ISSUE, TIME_ISSUE, ACCT_NO) VALUES (12326, 'Samuel', '30:03:2020', '11:00','10:04:2020,'11:30','001');
--INSERT INTO RETURN (REG_NO, NAME, DATE_RETURN, TIME_RETURN, DATE_ISSUE, TIME_ISSUE, ACCT_NO) VALUES (12327, 'Sid', '30:03:2020', '11:00','10:04:2020,'11:30','002');
--INSERT INTO RETURN (REG_NO, NAME, DATE_RETURN, TIME_RETURN, DATE_ISSUE, TIME_iSSUE, ACCT_NO) VALUES (12328, 'Tammy', '30:03:2020', '11:00','10:04:2020,'11:30','003');
