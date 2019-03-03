import java.io.IOException
import java.util.Scanner
import protocol.Protocol

class CSftp {
  val MAX_LEN = 255
  val DEFAULT_PORT = "21"
  val ARG_CNT = 2
  val SOUT_PREFIX_TO = "-->"
  val SOUT_PREFIX_FROM = "<--"

  def main(args: Array[String]): Unit = {
    val ftpPrefix = "csftp> "
    try {
      print(ftpPrefix)
      val sc = new Scanner(System.in)
      while (sc.hasNextLine) {
        parseCommand(sc.nextLine.getBytes())
        print(ftpPrefix)
      }
    } catch {
      case IOException => handleScannerFailure()
    }
  }

  def handleScannerFailure(): Unit = {
    println("0xFFFE Input error while reading commands, terminating")
    // Close connection
    System.exit(1)
  }

  def checkArguments(args : Array[String]): Array[String] = {
    if (args.length == ARG_CNT) {

    }

    args
  }

  def parseCommand(cmdString : Array[Byte]) : Unit = {
    if (cmdString(0) == '#') {
      return
    }

    val cmdInput = new String(cmdString).trim()
    if (cmdInput.isEmpty) {
      return
    }

    val cmdInputArray = cmdInput.split("\\s+")
    val protocol = Protocol.fromString(cmdInputArray(0))
  }

}
