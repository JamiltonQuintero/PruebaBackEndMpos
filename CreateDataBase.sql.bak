CREATE DATABASE MposPrueba;

INSERT INTO user_mpos ( date_of_creation, date_of_last_entry, email,full_name, lastpasswordresetdate, password, state,username)
VALUES ('2022-04-15','2022-04-15','transportador1118@Gmail.com','Jamilton Alonso Quintero Osorio','2022-04-12','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi',1 ,'admin')

INSERT INTO user_mpos (date_of_creation,date_of_last_entry,email,full_name,lastpasswordresetdate,password,state,username)
VALUES('2022-04-15','2022-04-15','user@Gmail.com','user user user user','2022-04-12','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',1,'user')

INSERT INTO authority_mpos(NAME) VALUES ('ROLE_USER');
INSERT INTO authority_mpos (NAME) VALUES ('ROLE_ADMIN');

INSERT INTO user_authority (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO user_authority (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO user_authority(USER_ID, AUTHORITY_ID) VALUES (2, 1);

INSERT INTO product_category(date_of_creation,date_of_last_update,name,state) VALUES('2022-04-17 13:15:54.503','2022-04-17 19:21:57.027','Corporal',1)
INSERT INTO product_category(date_of_creation,date_of_last_update,name,state) VALUES('2022-04-17 13:15:54.503','2022-04-17 19:21:57.027','Capilar',1)

INSERT INTO product (date_of_creation,date_of_last_update,name,price,state,product_category_id) VALUES('2022-04-17 13:55:17.960','2022-04-17 19:27:41.297','Crema de manos','50000',1,1)
INSERT INTO product (date_of_creation,date_of_last_update,name,price,state,product_category_id) VALUES('2022-04-17 13:55:17.960','2022-04-17 19:27:41.297','Shampoo anti aspa','5000',1,2)
INSERT INTO product (date_of_creation,date_of_last_update,name,price,state,product_category_id) VALUES('2022-04-17 13:55:17.960','2022-04-17 19:27:41.297','Gel','8000',1,2)

INSERT INTO product_list_of_tags (product_id ,list_of_tags) VALUES (1, 'Manos')
INSERT INTO product_list_of_tags (product_id ,list_of_tags) VALUES (1, 'Crema')
INSERT INTO product_list_of_tags (product_id ,list_of_tags) VALUES (2, 'Shampoo')
INSERT INTO product_list_of_tags (product_id ,list_of_tags) VALUES (3, 'Gomina')