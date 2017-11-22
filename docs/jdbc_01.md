JDBC最终是为了实现如下目标：
* 通过使用标准的SQL语句，甚至是专门的SQL扩展，程序员就可以利用Java语言开发访问数据库的应用，同时还依旧遵守Java语言的相关规范；
* 数据库供应商和数据库工具开发商可以提供底层的驱动程序，可以优化各自数据库产品的驱动程序。


1. 注册驱动器类
两种方式：
* 在Java程序中加载驱动器类：Class.forName("com.mysql.jdbc.Driver");
* 设置jdbc.drivers属性: System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
在这种方式中可以提供多个驱动器，用冒号将它们分开：
com.mysql.jdbc.Driver:org.postgresql.Driver

2. 连接到数据库
驱动管理器遍历所有注册过的驱动程序，以便找到一个能够使用数据库URL中指定的子协议的驱动程序。
DriverManager.getConnection(url, username, passport);
getConnection()建立一个到指定数据库的连接，并返回一个Connection对象。

3. 创建Statement对象
Statement对象用于执行不带参数的SQL查询和更新，通过Connection的createStatement()方法创建。
Statement的executeUpdate()方法用于执行诸如INSERT、UPDATE、DELETE之类的DML操作，或CREATE TABLE、DROP TABLE之类的DDL操作。
Statement的executeQuery()方法用于执行SELECT查询语句。
execute()方法可以执行任意的SQL语句。
executeQuery()方法返回一个ResultSet类型的对象，可以通过它每次一行地迭代遍历所有的查询结果。

每个Connection对象可以创建一个或多个Statement对象，同一个Statement对象可以用于多个不相关的命令和查询，一个Statement对象只能
有一个打开的结果集(ResultSet)。
至少有一种常用的数据库(SQL Server)的JDBC驱动程序只允许同时存在一个活动的Statement对象，DatabaseMetadata的getMaxStatements()方法可以获得
JDBC驱动程序支持的同时活动的语句对象的总数。

使用完ResultSet、Statement、Connection对象后，应该立即调用close方法，这些对象都使用了规模较大的数据结构和数据库存服务器上的有限资源。






