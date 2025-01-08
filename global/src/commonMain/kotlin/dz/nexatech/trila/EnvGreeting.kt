package dz.nexatech.trila

class EnvGreeting(private val environment: Environment) {

    fun greet(): String {
        return "Env: ${environment.name}!"
    }
}