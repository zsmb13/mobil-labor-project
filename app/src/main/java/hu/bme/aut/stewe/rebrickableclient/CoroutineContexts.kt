package hu.bme.aut.stewe.rebrickableclient

import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.newFixedThreadPoolContext
import kotlin.coroutines.experimental.CoroutineContext
import kotlinx.coroutines.experimental.android.UI as AndroidUI

const val THREAD_COUNT = 3

object CoroutineContexts {
    val IO: CoroutineContext = DefaultDispatcher
    val NETWORK: CoroutineContext = newFixedThreadPoolContext(THREAD_COUNT, "networkIO")
    val UI: CoroutineContext = AndroidUI
}