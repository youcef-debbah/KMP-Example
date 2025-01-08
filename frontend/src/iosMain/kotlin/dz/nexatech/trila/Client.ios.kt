package dz.nexatech.trila

import platform.UIKit.UIDevice

class IOSClient: Client {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getClient(): Client = IOSClient()