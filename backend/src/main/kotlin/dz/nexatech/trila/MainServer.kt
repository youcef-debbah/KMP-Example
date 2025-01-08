package dz.nexatech.trila

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val env = ServerEnvironment()

fun main() {
    println("starting trila server: " + env.name)
    embeddedServer(Netty,
        port = System.getenv("PORT")?.toInt() ?: 8080,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    routing {
        get("/") {
            call.respondText("main trila server: " + env.name + " at: " + System.currentTimeMillis())
        }
    }
}