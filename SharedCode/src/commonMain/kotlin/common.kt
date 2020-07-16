package com.jetbrains.handson.mpp.mobile

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.cio.websocket.FrameType.Companion.get
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

expect fun platformName(): String

fun createApplicationScreenMessage(): String {

    return "Kotlin Rocks on ${platformName()}"
}


