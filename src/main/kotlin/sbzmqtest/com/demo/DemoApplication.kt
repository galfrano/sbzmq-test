package sbzmqtest.com.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import kotlinx.coroutines.*

@SpringBootApplication
class DemoApplication: CommandLineRunner {
	override fun run(vararg args: String?) = runBlocking<Unit> {
		launch{
			startRouter()
			println(Thread.currentThread().name)
		}
		launch(newSingleThreadContext("redDealer")){
			println(Thread.currentThread().name)
			val dealer = getDealer("red")
			for(i in 1..1000) {
				sendFromDealer(dealer, "This is message number $i")
			}
		}
		launch(newSingleThreadContext("blueDealer")) {
			println(Thread.currentThread().name)
			val dealer = getDealer("blue")
			for (i in 1..1000) {
				sendFromDealer(dealer, "This is message number $i")
			}
		}
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}