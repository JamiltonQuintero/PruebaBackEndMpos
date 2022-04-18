USE [MposPrueba]
GO

/*USER*/

CREATE TABLE [dbo].[user_mpos](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[date_of_creation] [datetime] NULL UNIQUE,
	[date_of_last_entry] [datetime] NULL,
	[email] [varchar](50) NULL,
	[full_name] [varchar](50) NULL,
	[lastpasswordresetdate] [datetime] NULL,
	[password] [varchar](100) NULL ,
	[state] [int] NULL,
	[username] [varchar](50) NULL UNIQUE,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_7d9blwx97al04gdm0y0vbnuw5] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


/* AUTH*/
CREATE TABLE [dbo].[authority_mpos](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


/* User AUTH*/
CREATE TABLE [dbo].[user_authority](
	[user_id] [numeric](19, 0) NOT NULL,
	[authority_id] [numeric](19, 0) NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[user_authority]  WITH CHECK ADD  CONSTRAINT [FK86pd3hp0lwwew9qe8uiy44dje1] FOREIGN KEY([user_id])
REFERENCES [dbo].[user_mpos] ([id])
GO

ALTER TABLE [dbo].[user_authority] CHECK CONSTRAINT [FK86pd3hp0lwwew9qe8uiy44dje1]
GO

ALTER TABLE [dbo].[user_authority]  WITH CHECK ADD  CONSTRAINT [FKkw9w2p3274ov3dm23axc8n16y1] FOREIGN KEY([authority_id])
REFERENCES [dbo].[authority_mpos] ([id])
GO

ALTER TABLE [dbo].[user_authority] CHECK CONSTRAINT [FKkw9w2p3274ov3dm23axc8n16y1]
GO

/*PRODUCT*/

CREATE TABLE [dbo].[product](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[date_of_creation] [datetime] NULL,
	[date_of_last_update] [datetime] NULL,
	[name] [varchar](50) NULL UNIQUE,
	[price] [float] NULL,
	[state] [int] NULL,
	[product_category_id] [numeric](19, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_jmivyxk9rmgysrmsqw15lqr5b] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FKcwclrqu392y86y0pmyrsi649r1] FOREIGN KEY([product_category_id])
REFERENCES [dbo].[product_category] ([id])
GO

ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FKcwclrqu392y86y0pmyrsi649r1]
GO

/*PROCUT CATEGORY*/

CREATE TABLE [dbo].[product_category](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[date_of_creation] [datetime] NULL,
	[date_of_last_update] [datetime] NULL,
	[name] [varchar](50) NULL UNIQUE,
	[state] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_9qvug0bmpkmxkkx33q51m7do7] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/*LIST OF TAGS*/

CREATE TABLE [dbo].[product_list_of_tags](
	[product_id] [numeric](19, 0) NOT NULL,
	[list_of_tags] [varchar](255) NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[product_list_of_tags]  WITH CHECK ADD  CONSTRAINT [FKmsa51g5di9edl4n9qugoloyi71] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO

ALTER TABLE [dbo].[product_list_of_tags] CHECK CONSTRAINT [FKmsa51g5di9edl4n9qugoloyi71]
GO

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