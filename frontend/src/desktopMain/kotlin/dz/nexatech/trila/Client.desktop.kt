package dz.nexatech.trila

class DesktopClient : Client {
    override val name: String = "Desktop " + KotlinVersion.CURRENT
}

actual fun getClient(): Client = DesktopClient()