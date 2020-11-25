INSERT INTO Company(headquarter, name)
VALUES ('Stettbach', 'Helsana'), ('Kloten', 'AMAG'), ('Washington', 'Microsoft');

INSERT INTO EVENT(name, ort)
VALUES ('Daily Meeting', 'Sitzungszimmer1'), ('Apero', 'Dachterasse'), ('Test day', 'Sizungszimmer3');

INSERT INTO USER(password, username)
VALUES ('pS2UNr', 'User1'), ('ZBu33h', 'User2'), ('3SadXc', 'User3');

INSERT INTO USER_COMPANY(user_id, company_id)
VALUES (1, 3), (2, 2), (3, 1);

INSERT INTO ENTRY(check_in, check_out, applicationuser_id, event_id)
VALUES ('2020-11-25T10:38:11.475Z', '2020-11-26T10:16:19.753Z', 3, 2), ('2020-11-25T10:38:11.475Z', '2020-11-26T10:16:19.753Z', 1, 3), ('2020-11-25T10:38:11.475Z', '2020-11-26T10:16:19.753Z', 2, 1);