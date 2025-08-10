create database BackendStore
go

use BackendStore
go

create table Roles(
	RoleId int primary key identity(1, 1),
	RoleName nvarchar(30) not null,
)
go

create table Users(
	UserId bigint primary key identity(1000, 1),
	Username nvarchar(32) not null unique,
	Email nvarchar(254) not null unique,
	PasswordHash nvarchar(64) not null,
	CreationDate datetime2(3) not null,
	RoleId int not null,
	IsActive bit not null,
	LastLoginDate datetime2(3),
	foreign key (RoleId) references Roles(RoleId)
)
go

create table SiteVisits(
	VisitId int PRIMARY KEY IDENTITY(1, 1),
	Url nvarchar(100),
	VisitDate datetime2(3) not null,
	UserId bigint not null,
	foreign key (UserId) references Users(UserId) on delete cascade,
)
go


create table Categories(
	CategoryId int primary key identity(1, 1),
	CategoryName nvarchar(100)
)
go

create table Products(
	ProductId bigint primary key identity(1000, 1),
	ProductName nvarchar(100) not null,
	Price decimal(10,2) not null,
	StockQuantity int not null,
	ImageUrl nvarchar(500) not null,
	IsActive bit not null,
	ProductDescription nvarchar(1024) not null,
	CategoryId int,
	Specifications nvarchar(max) not null,
	CreationDate datetime2(3) not null,
	foreign key (CategoryId) references Categories(CategoryId)
)
go

create table Cart(
	UserId bigint not null,
	ProductId bigint not null,
	Quantity int not null,
	foreign key (UserId) references Users(UserId) on delete cascade,
	foreign key (ProductId) references Products(ProductId) on delete cascade,
	unique(UserId, ProductId)
)
go

create table Comments (
	CommentId bigint PRIMARY KEY IDENTITY(1,1),
	UserId bigint not null,
	ProductId bigint not null,
	CommentDate datetime2(3) not null,
	CommentContent nvarchar(500) not null,
	foreign key (UserId) references Users(UserId),
	foreign key (ProductId) references Products(ProductId)
)
go

CREATE INDEX IX_Products_CategoryId ON Products(CategoryId);
CREATE INDEX IX_Cart_UserId ON Cart(UserId);
CREATE INDEX IX_Comments_ProductId ON Comments(ProductId);

insert into Roles values('User')
insert into Roles values('Manager')
insert into Roles values('Admin')
go

