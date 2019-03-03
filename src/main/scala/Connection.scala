import java.io.{BufferedReader, IOException, InputStreamReader}
import java.net.Socket

class Connection(socket : Socket) {

  val CONN_TIMEOUT_MS = 20000
  val DATA_TIMEOUT_MS = 10000

  def getSocketFor(hostAndPort : Array[String]): Socket = {
    val address = hostAndPort(0)
    val port = Integer.valueOf(hostAndPort(0))
    getControlConnection(address, port)
  }

  private def getControlConnection(host : String, port : Integer): Socket = {
    val socket = connect(host, port, CONN_TIMEOUT_MS) // immutability
    val in = new BufferedReader(new InputStreamReader(socket.getInputStream))
    var connectedMsg = null
    if (connectedMsg = in.readLine() != null) {
      println(connectedMsg)
    }

    socket
  }

  private def connect(host : String, port : Integer, timeout : Integer): Socket = {
    val theSocket = new Socket(host, port)
    theSocket.setSoTimeout(timeout)
    theSocket
  }

  def getDataConnection(host : String, port : Integer, timeout : Integer): Socket = {
    try {
      connect(host, port, DATA_TIMEOUT_MS)
    } catch {
      case e: IOException => printDataConnectionError(e, host, port)
    }
  }

  private def printDataConnectionError(e : IOException, host : String, port : Integer) = {
    val message = s"0x3A2 Data transfer connection to $host on port $port failed to open."
    println(e)
    println(message)
    null
  }
}
