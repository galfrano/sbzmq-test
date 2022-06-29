package sbzmqtest.com.demo
import org.zeromq.ZMQ

fun getDealer(id: String): ZMQ.Socket {
    val context = ZMQ.context(1)
    val socket = context.socket(ZMQ.DEALER)
    socket.identity = toSend(id)
    socket.connect(routerAddress)
    return socket
}

fun sendFromDealer(socket: ZMQ.Socket, message: String) {
    socket.send(toSend(message), 0)
}