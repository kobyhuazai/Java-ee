## 一个基本的CRUD项目（4）

### 说明

1.之前的版本（1）、（2）、（3）没有使用连接池，本项目使用了c3p0连接池。

2.在DAO层的方法中使用了Txqueryrunner，相当于（3）中的queryrunner的升级版。

3.使用BaseServlet实现了一个Servlet处理多个请求。

### 准备

mysql-connector-java-5.0.8-bin.jar

c3p0-0.9.5.2.jar

commons-dbutils.jar

itcast-tools.jar(一个被广泛使用的小工具)

mchange-commons-java.jar

### 遇到的困难与解决办法

由于javabean的id是自动生成的，所以需要在执行插入语句之后获取自动生产的id，之前的方法是使用一个ResultSet获取。

在网上搜到一个利用sql语句："SELECT LAST_INSERT_ID()"获取id的方法，实现了功能。



