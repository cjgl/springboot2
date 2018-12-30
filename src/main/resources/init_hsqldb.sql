/*项目表*/
drop table t_sys_project if exists;
create table t_sys_project(
projectid int primary key IDENTITY,
projectname varchar(50),
remark varchar(200),
createtime varchar(23),
updatetime varchar(23),
delflag varchar(1)
);

/*子系统表*/
drop table t_sys_subsystem if exists;
create table t_sys_subsystem(
subsystemid int primary key IDENTITY,
projectid int,
subsystemname varchar(50),
type int,
remark varchar(200),
createtime varchar(23),
updatetime varchar(23),
delflag varchar(1)
);

/*菜单表*/
drop table t_sys_menu if exists;
create table t_sys_menu(
menuid int primary key IDENTITY,
subsystemid int,
pmenuid int,
menuname varchar(50),
menuurl varchar(500)
);

/*角色表*/
drop table t_sys_role if exists;
create table t_sys_role(
roleid int primary key IDENTITY,
projectid int,
subsystemid int,
rolename varchar(50),
remark varchar(200),
createtime varchar(23),
updatetime varchar(23),
delflag varchar(1)
);

/*用户表*/
drop table t_sys_user if exists;
create table t_sys_user(
id int primary key IDENTITY,
projectid int,
subsystemid int,
loginname varchar(50),
username varchar(50),
pwd varchar(50),
createtime varchar(23),
updatetime varchar(23),
delflag varchar(1)
);

insert into t_sys_project(projectid, projectname, remark, createtime, updatetime, delflag)
values(0, '后台管理项目', '后台管理项目', '2018-12-27 13:15:00', '2018-12-27 13:15:00', 0);

insert into t_sys_subsystem(subsystemid, projectid, subsystemname, type, remark, createtime, updatetime, delflag)
values(0, 0, '后台管理子系统', 0, '后台管理子系统', '2018-12-27 13:15:00', '2018-12-27 13:15:00', 0);

insert into t_sys_role(roleid, projectid, subsystemid, rolename, remark, createtime, updatetime, delflag)
values(0, 0, 0, '后台管理角色', '后台管理角色', '2018-12-27 13:15:00', '2018-12-27 13:15:00', 0);

insert into t_sys_user(id, projectid, subsystemid, loginname, username, pwd, createtime, updatetime, delflag)
values(0, 0, 0, 'admin', '超级管理员', '123456', '2018-12-27 13:15:00', '2018-12-27 13:15:00', 0)

