package sbzmqtest.com.demo

import java.io.ByteArrayOutputStream

fun toSend(message: String): ByteArray {
    val output = ByteArrayOutputStream()
    output.write(message.toByteArray())
    output.write(0)
    return output.toByteArray()
}

fun toReply(message: String, id: String): ByteArray {
    val output = ByteArrayOutputStream()
    output.write(id.toByteArray())
    output.write(0)
    output.write(message.toByteArray())
    return output.toByteArray()
}

fun received(message: ByteArray): String {
    return String(message, 0, message.size - 1)
}

fun print2Shell(message: String, color: String) {
    when(color) {
        "blue" -> println("\u001B[0;34m$message \u001B[0m")
        "red" -> println("\u001B[0;31m$message \u001B[0m")
        else -> {
            println("\u001B[0m$message \u001B[0m")
        }
    }
}