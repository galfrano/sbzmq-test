package sbzmqtest.com.demo
import org.zeromq.ZMQ

const val routerAddress = "tcp://*:50001"
//const val routerAddress = "ipc://zmq_router"

fun startRouter() {
    val context = ZMQ.context(1)
    val socket = context.socket(ZMQ.ROUTER)
    socket.bind(routerAddress)
    var x = 1
    while (true) {
        val sender = received(socket.recv(0))
        val message = received(socket.recv(0))
        print2Shell("$x - $sender sent message: $message", sender)
        x += 1
    }
}