@file:OptIn(ExperimentalResourceApi::class)

package dz.nexatech.trila

import org.jetbrains.compose.resources.ExperimentalResourceApi

class ClientGreeting {
    private val client: Client = getClient()

    fun greet(): String {
        return "client: ${client.name}!"
    }
}