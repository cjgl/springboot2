drop table user if exists;
drop table uploadfile if exists;
drop table stock if exists;
drop table project if exists;

create table user(
id int primary key IDENTITY,
name varchar(20),
pwd varchar(20),
depid int,
createtime timestamp,
updatetime timestamp
);

create table uploadfile(
id int primary key IDENTITY,
name varchar(80),
type varchar(120),
path varchar(200),
time timestamp,
remark varchar(100));

create table stock(
id int primary key IDENTITY,
time date,
name varchar(100),
price float,
total int,
unit varchar(10),
remark varchar(100)
);

create table project(
id int primary key IDENTITY,
name varchar(100),
summary varchar(1000),
remark varchar(100)
);

insert into user(name, pwd, createtime, updatetime)
values('抚远将军', '123456', '2014-07-10 22:22:00', '2014-07-10 22:22:00');
insert into user(name, pwd, createtime, updatetime)
values('参将', '123456', '2014-07-10 22:26:00', '2014-07-10 22:26:00');

insert into uploadfile(name, type, time, remark)
values('text.txt', 'txt', now(), '原始数据，不存在');

insert into stock(time, name, price, total, unit, remark)
values('2014-5-1', '大刀', 100, 10, '把', '价格银两');
insert into stock(time, name, price, total, unit, remark)
values('2014-5-2', '军马', 500, 20, '匹', '价格银两');

insert into project(name, summary, remark)
values('开发环境', '开发环境说明。', '静态页面');
insert into project(name, summary, remark)
values('用户管理', '支持双击行修改。', '数据库显示、新增、修改、删除');
insert into project(name, summary, remark)
values('文件管理', '简单文件管理（上传、下载和删除）。', '数据库显示、新增、删除');
insert into project(name, summary, remark)
values('库存管理', '1.库存显示;<br>2.库存的新增和修改，然后提交操作，进行数据库的新增和修改操作;<br>3.删除库存，直接从数据库中删除;<br>4.提交Excel，把提交文件中的库存信息保存到数据库（格式与导出的一致）;<br>5.把库存导出Excel文件', '模拟一张库存清单表');
insert into project(name, summary, remark)
values('项目说明', '对本项目进行简要说明', '数据库显示');