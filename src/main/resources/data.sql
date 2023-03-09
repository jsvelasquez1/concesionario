INSERT INTO AUTHORITIES(AUTHORITY) VALUES('ROLE_USER');
INSERT INTO AUTHORITIES(AUTHORITY) VALUES('ROLE_ADMIN');
INSERT INTO AUTHORITIES(AUTHORITY) VALUES('ROLE_MODERATOR');


INSERT INTO USERS(USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED)
VALUES ('user1', '$2a$12$vztWG1YZRKvPUjSLMfCGJ.32iSVknMHklskUck9eTaUpVwsos7QLa', true, true, true, true);
INSERT INTO USERS(USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED)
VALUES ('user2', '$2a$12$BAihRs7CO3hJgyC2JGEvFu5NflbH06Z1Z261l2SKXWncJbGmbmXru', true, true, true, true);
INSERT INTO USERS(USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED)
VALUES ('user3', '$2a$12$oI50xEIgUON0zN1C2H397ucbDyicNs1FWC2/4tvSRvHqN7wxH7aq.', true, true, true, true);

INSERT INTO USERS_AUTHORITIES(USERS_ID, AUTHORITIES_ID) VALUES (1, 1);
INSERT INTO USERS_AUTHORITIES(USERS_ID, AUTHORITIES_ID) VALUES (1, 2);
INSERT INTO USERS_AUTHORITIES(USERS_ID, AUTHORITIES_ID) VALUES (1, 3);
INSERT INTO USERS_AUTHORITIES(USERS_ID, AUTHORITIES_ID) VALUES (2, 1);
INSERT INTO USERS_AUTHORITIES(USERS_ID, AUTHORITIES_ID) VALUES (3, 1);