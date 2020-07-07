## 学生选课系统
### 开发环境

Spring boot+Vue+Mysql

### 数据库设计

#### I.关系设计

 **用户表**

用户表(用户号，用户名，密码，角色)

```java
user(id,username,password,role)
```

主键：id

**院系表**  

院系表(院系号，名称，地址，联系电话)

```java
d(yxh,mc,dz,lxdh)  
```

主键：yxh

**学生表**

学生表（学号，姓名，性别，出生日期，院系号）

```java
s(xh,xm,xb,csrq,sjhm,yxh)
```

主键：xh

外键：yxh

**教师表**

教师表（工号，姓名，性别，出生日期，学历，基本工资，院系号）

```java
t(gh,xm,xb,csrq,xl,jbgz,yxh)
```

主键：gh

外键：yxh

**课程表**

课程表（课号，课名，学分，学时，院系号）

```java
c(kh,km，xf,xs,yxh)
```

主键：kh

外键：yxh

**开课表**

开课表 （课号，工号，学期，上课时间）

```java
o(kh,gh,xq,sksj)
```

主键：(kh,gh,xq)

外键：kh,gh

**选课表**

选课表（学号，课号，工号，学期，平时成绩，考试成绩，总评成绩）

```
e(xh,kh,gh,xq,pscj,kscj,zpcj)
```

主键：(xh,kh,gh,xq)

外键：xh,kh,gh

#### II.触发器

a.学生表添加学生之后，用户表中添加该学生。

```sql
DROP TRIGGER IF EXISTS addUserS;
 create trigger addUserS before insert on s 
 for each row 
 insert into user(username,password,role) values(new.xh,new.xh,"stedent");
```

b.教师表添加教师之后，用户表中添加该教师。

```sql
DROP TRIGGER IF EXISTS addUserT;
create trigger addUserT before insert on t 
for each row 
insert into user(username,password,role) values(new.gh,new.gh,"teacher");
```

c.学生表删除学生之后，用户表中删除该学生。

```sql
 DROP TRIGGER IF EXISTS deleteUserS;
 create trigger deleteUserS before delete on s 
 for each row 
 delete from user where username=old.xh;
```

d.教师表删除教师之后，用户表中删除该教师。

```sql
DROP TRIGGER IF EXISTS deleteUserT;
create trigger deleteUserT before delete on t 
for each row 
delete from user where username=old.gh;
```


#### 功能设计

后端的主要功能设计如下图：

![功能设计](https://media-yuanxin.oss-cn-hangzhou.aliyuncs.com/xkImg/%E5%8A%9F%E8%83%BD%E8%AE%BE%E8%AE%A1.jpg)

 
