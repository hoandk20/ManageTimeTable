USE [TimeTable]
GO
/****** Object:  Table [dbo].[tblClass]    Script Date: 12-Jul-21 11:35:50 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblClass](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
 CONSTRAINT [PK_tblClass] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRoom]    Script Date: 12-Jul-21 11:35:50 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoom](
	[id] [int] NOT NULL,
	[RoomName] [nvarchar](max) NULL,
 CONSTRAINT [PK_tblRoom] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblSlot]    Script Date: 12-Jul-21 11:35:50 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSlot](
	[slot] [int] NOT NULL,
	[time] [nvarchar](max) NULL,
 CONSTRAINT [PK_slot] PRIMARY KEY CLUSTERED 
(
	[slot] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblTeacher]    Script Date: 12-Jul-21 11:35:50 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTeacher](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nchar](31) NOT NULL,
	[slot] [int] NULL,
	[classid] [int] NULL,
	[roomid] [int] NULL,
	[date] [date] NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tblClass] ON 

INSERT [dbo].[tblClass] ([id], [name]) VALUES (1, N'SE1433')
INSERT [dbo].[tblClass] ([id], [name]) VALUES (2, N'SE1444')
INSERT [dbo].[tblClass] ([id], [name]) VALUES (3, N'SE1455')
INSERT [dbo].[tblClass] ([id], [name]) VALUES (4, N'IA1421')
INSERT [dbo].[tblClass] ([id], [name]) VALUES (5, N'IA1533')
INSERT [dbo].[tblClass] ([id], [name]) VALUES (6, N'IA1623')
SET IDENTITY_INSERT [dbo].[tblClass] OFF
GO
INSERT [dbo].[tblRoom] ([id], [RoomName]) VALUES (1, N'R201')
INSERT [dbo].[tblRoom] ([id], [RoomName]) VALUES (2, N'R102')
INSERT [dbo].[tblRoom] ([id], [RoomName]) VALUES (3, N'R103')
INSERT [dbo].[tblRoom] ([id], [RoomName]) VALUES (4, N'L304')
INSERT [dbo].[tblRoom] ([id], [RoomName]) VALUES (5, N'L201')
INSERT [dbo].[tblRoom] ([id], [RoomName]) VALUES (6, N'L202')
GO
INSERT [dbo].[tblSlot] ([slot], [time]) VALUES (1, N'7h30'' - 9h')
INSERT [dbo].[tblSlot] ([slot], [time]) VALUES (2, N'9h10''- 10h40''')
INSERT [dbo].[tblSlot] ([slot], [time]) VALUES (3, N'10h50'' - 12h20''')
INSERT [dbo].[tblSlot] ([slot], [time]) VALUES (4, N'12h50'' - 2h20''')
INSERT [dbo].[tblSlot] ([slot], [time]) VALUES (5, N'2h30'' - 4h')
INSERT [dbo].[tblSlot] ([slot], [time]) VALUES (6, N'4h10'' - 5h40''')
GO
SET IDENTITY_INSERT [dbo].[tblTeacher] ON 

INSERT [dbo].[tblTeacher] ([id], [name], [slot], [classid], [roomid], [date]) VALUES (1, N'Hoandk                         ', 2, 1, 2, CAST(N'2021-07-11' AS Date))
INSERT [dbo].[tblTeacher] ([id], [name], [slot], [classid], [roomid], [date]) VALUES (2, N'hoandk                         ', 1, 5, 6, CAST(N'2021-07-08' AS Date))
INSERT [dbo].[tblTeacher] ([id], [name], [slot], [classid], [roomid], [date]) VALUES (1002, N'hoandk123                      ', 5, 5, 6, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[tblTeacher] ([id], [name], [slot], [classid], [roomid], [date]) VALUES (2002, N'hoandk                         ', 4, 1, 1, CAST(N'2021-07-12' AS Date))
SET IDENTITY_INSERT [dbo].[tblTeacher] OFF
GO
ALTER TABLE [dbo].[tblTeacher]  WITH CHECK ADD  CONSTRAINT [FK_tblTeacher_tblClass] FOREIGN KEY([classid])
REFERENCES [dbo].[tblClass] ([id])
GO
ALTER TABLE [dbo].[tblTeacher] CHECK CONSTRAINT [FK_tblTeacher_tblClass]
GO
ALTER TABLE [dbo].[tblTeacher]  WITH CHECK ADD  CONSTRAINT [FK_tblTeacher_tblRoom1] FOREIGN KEY([roomid])
REFERENCES [dbo].[tblRoom] ([id])
GO
ALTER TABLE [dbo].[tblTeacher] CHECK CONSTRAINT [FK_tblTeacher_tblRoom1]
GO
ALTER TABLE [dbo].[tblTeacher]  WITH CHECK ADD  CONSTRAINT [FK_tblTeacher_tblSlot] FOREIGN KEY([slot])
REFERENCES [dbo].[tblSlot] ([slot])
GO
ALTER TABLE [dbo].[tblTeacher] CHECK CONSTRAINT [FK_tblTeacher_tblSlot]
GO
