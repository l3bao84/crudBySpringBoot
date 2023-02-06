USE [master]
GO
/****** Object:  Database [CrudProject]    Script Date: 2/6/2023 10:21:34 PM ******/
CREATE DATABASE [CrudProject]
 CONTAINMENT = NONE
 ON  PRIMARY
( NAME = N'CrudProject', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\CrudProject.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON
( NAME = N'CrudProject_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\CrudProject_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [CrudProject] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CrudProject].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CrudProject] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [CrudProject] SET ANSI_NULLS OFF
GO
ALTER DATABASE [CrudProject] SET ANSI_PADDING OFF
GO
ALTER DATABASE [CrudProject] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [CrudProject] SET ARITHABORT OFF
GO
ALTER DATABASE [CrudProject] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [CrudProject] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [CrudProject] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [CrudProject] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [CrudProject] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [CrudProject] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [CrudProject] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [CrudProject] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [CrudProject] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [CrudProject] SET  DISABLE_BROKER
GO
ALTER DATABASE [CrudProject] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [CrudProject] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [CrudProject] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [CrudProject] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [CrudProject] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [CrudProject] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [CrudProject] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [CrudProject] SET RECOVERY SIMPLE
GO
ALTER DATABASE [CrudProject] SET  MULTI_USER
GO
ALTER DATABASE [CrudProject] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [CrudProject] SET DB_CHAINING OFF
GO
ALTER DATABASE [CrudProject] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
GO
ALTER DATABASE [CrudProject] SET TARGET_RECOVERY_TIME = 60 SECONDS
GO
ALTER DATABASE [CrudProject] SET DELAYED_DURABILITY = DISABLED
GO
ALTER DATABASE [CrudProject] SET ACCELERATED_DATABASE_RECOVERY = OFF
GO
ALTER DATABASE [CrudProject] SET QUERY_STORE = OFF
GO
USE [CrudProject]
GO
/****** Object:  Table [dbo].[category]    Script Date: 2/6/2023 10:21:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[categoryid] [varchar](255) NOT NULL,
	[category_img] [varchar](255) NULL,
	[category_name] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED
(
	[categoryid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 2/6/2023 10:21:34 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[productid] [varchar](255) NOT NULL,
	[categoryid] [varchar](255) NULL,
	[product_img] [varchar](255) NULL,
	[product_name] [nvarchar](255) NULL,
	[product_numbers] [int] NULL,
	[product_price] [int] NULL,
PRIMARY KEY CLUSTERED
(
	[productid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [CrudProject] SET  READ_WRITE
GO
