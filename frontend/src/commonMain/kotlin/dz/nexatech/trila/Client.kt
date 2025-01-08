package dz.nexatech.trila

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource

interface Client {
    val name: String
}

expect fun getClient(): Client

@Composable
fun ClientApp(environment: Environment) {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(EnvGreeting(environment).greet())
                Text(ClientGreeting().greet())
                Image(painterResource(Res.drawable.vector_example), contentDescription = null)
            }
        }
    }
}