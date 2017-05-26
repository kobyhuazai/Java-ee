## 一个基本的CRUD项目（2）

相比于上一个最基本CRUD项目 [j2ee](https://github.com/kobyhuazai/Java-ee/tree/master/j2ee "j2ee") ,该项目有两方面改进：

1. 在DAO层的方法中，使用commons-dbutils——一个简化Jdbc的小类库操作数据库。
2. addHero，editHero，Herolist由之前的Servlet改写为jsp的形式。