package hu.bme.aut.stewe.rebrickableclient

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext
import kotlinx.coroutines.experimental.android.UI as AndroidUI

const val THREAD_COUNT = 3

object CoroutineContexts {
    val IO: CoroutineContext = DefaultDispatcher
    val NETWORK: CoroutineContext = newFixedThreadPoolContext(THREAD_COUNT, "networkIO")
    val UI: CoroutineContext = AndroidUI
}

fun launchAsync(block: suspend CoroutineScope.() -> Unit): Job =
        launch(CoroutineContexts.UI) { block() }

suspend fun <T> asyncNetwork(block: suspend CoroutineScope.() -> T): Deferred<T> =
        async(CoroutineContexts.NETWORK) { block() }

