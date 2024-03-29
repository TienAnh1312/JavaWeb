USE [ProductSample]
GO
/****** Object:  Table [dbo].[product]    Script Date: 1/17/2024 9:40:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[ProID] [int] IDENTITY(1,1) NOT NULL,
	[ProName] [varchar](100) NULL,
	[ProDesc] [text] NULL,
	[ProDate] [datetime] NULL,
	[ProQty] [int] NULL,
	[ProPrice] [float] NULL,
	[ProImage] [varchar](200) NULL,
	[ProStatus] [tinyint] NULL,
	[ProWarranty] [tinyint] NULL,
	[CateID] [int] NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[ProID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
