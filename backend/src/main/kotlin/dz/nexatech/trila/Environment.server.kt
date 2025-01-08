package dz.nexatech.trila

class ServerEnvironment: Environment {
    override val name: String = "server JDK " + Runtime.version()
}