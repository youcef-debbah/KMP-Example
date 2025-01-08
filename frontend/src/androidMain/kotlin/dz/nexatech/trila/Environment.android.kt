package dz.nexatech.trila

import android.os.Build

class AndroidEnvironment : Environment {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}