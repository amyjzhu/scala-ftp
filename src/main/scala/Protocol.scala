package protocol

object Protocol {

  sealed abstract class Protocol(
                                val command : String,
                                val handle : Array[String] => Unit
                                )

  case object USER extends Protocol("user", handleUser)
  case object PW extends Protocol("pw", handlePw)
  case object QUIT extends Protocol("quit", handleQuit)
  case object GET extends Protocol("get", handleGet)
  case object FEATURES extends Protocol("features", handleFeatures)
  case object CD extends Protocol("cd", handleCd)
  case object DIR extends Protocol("dir", handleDir)

  val protocols : List[Protocol] = List(USER, PW, QUIT, GET, FEATURES, CD, DIR)
  val nameToProtocols : Map[String, Protocol] = protocols.foldLeft(Map.empty[String, Protocol]) {
    (acc, elem) => acc+(elem.command -> elem) }


  def main(args: Array[String]): Unit = {
    print(nameToProtocols)
  }
  def fromString(string : String) : Protocol = {

  }

  def handleUser(cmds : Array[String]) : Unit = {

  }

  def handlePw(cmd : Array[String]) : Unit = {

  }

  def handleQuit(cmd : Array[String]) : Unit = {

  }

  def handleGet(cmd : Array[String]) : Unit = {

  }

  def handleFeatures(cmd : Array[String]) : Unit = {

  }

  def handleCd(cmd : Array[String]) : Unit = {

  }

  def handleDir(cmd : Array[String]) : Unit = {

  }
}