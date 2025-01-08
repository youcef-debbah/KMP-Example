package dz.nexatech.trila

class AndroidClient : Client {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getClient(): Client = AndroidClient()