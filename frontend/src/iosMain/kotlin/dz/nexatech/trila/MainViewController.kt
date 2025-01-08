package dz.nexatech.trila

import androidx.compose.ui.window.ComposeUIViewController

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController {
    ClientApp(IOSEnvironment())
}