package dz.nexatech.trila

import platform.UIKit.UIDevice

class IOSEnvironment: Environment {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}