package play.api

import com.sandinh.PlayAlone
import org.specs2.mutable.Specification
import play.api.db.DB
import anorm._
import anorm.SqlParser._
import play.api.Play.current

/**
 * @author giabao
 * created: 2013-10-05 17:07
 * Copyright(c) 2011-2013 sandinh.com
 */
class DBSpec extends Specification{
  val sqlCreate =
    """CREATE TABLE Mock (
      | id integer NOT NULL AUTO_INCREMENT,
      | msg varchar(255) NOT NULL,
      | PRIMARY KEY (id)
      |);""".stripMargin

  val sqlInsert =
    """INSERT INTO Mock (msg) VALUES ('v1'), ({v2});"""

  val sqlSelect = """SELECT * FROM Mock ORDER BY id DESC;"""

  "DBPlugin" should{
    "execute sql using anorm" in {
      PlayAlone.start(configFile = "src/test/resources/conf/application.conf")

      Play.current.configuration.getString("db.default.driver") must beSome[String]

      DB.withConnection{implicit c =>
        SQL(sqlCreate).executeUpdate() === 0
      }

      DB.withConnection{implicit c =>
        SQL(sqlInsert).on("v2" -> "value2").executeUpdate() === 2
      }

      val parser = int("id") ~ str("msg") map flatten
      DB.withConnection{implicit c =>
        val l = SQL(sqlSelect).as(parser.*)
        l must have size 2
        l.head._2 === "value2"
      }
    }
  }
}
