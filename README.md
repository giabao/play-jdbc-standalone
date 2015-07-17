play-jdbc-standalone
====================
### What?
This library enable us to use [play-jdbc from playframework 2.4.x](https://github.com/playframework/playframework/blob/2.4.x/framework/src/play-jdbc/src/main/scala/play/api/db/DB.scala) without play itself.

For play version < 2.4 please use play-jdbc-standalone 2.1.x

### Why?
+ Your code & config (that use play-jdbc-standalone) will exactly same as if you [use play](http://www.playframework.com/documentation/2.4.x/ScalaDatabase)
+ So, you can use [anorm](http://www.playframework.com/documentation/2.4.x/ScalaAnorm) or [other database libraries](http://www.playframework.com/documentation/2.4.x/ScalaDatabaseOthers) (exactly) as in a full play app.

### How?
see [DBSpec.scala](https://github.com/giabao/play-jdbc-standalone/blob/master/src/test/scala/play/api/DBSpec.scala)

### Changelogs
see [CHANGES.md](CHANGES.md)

### Licence
This software is licensed under the Apache 2 license:
http://www.apache.org/licenses/LICENSE-2.0

Copyright 2013 Sân Đình (http://sandinh.com)
