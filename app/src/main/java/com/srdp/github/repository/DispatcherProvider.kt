package com.srdp.github.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

// comment by srdpatel: 4/7/2020 More on Dispatcher: https://medium.com/mindful-engineering/fast-lane-to-coroutines-bce8388ed82b
interface DispatcherProvider {

    // comment by srdpatel: 12/3/2019 single expression function, expression body
    fun main(): CoroutineDispatcher = Dispatchers.Main
    fun default(): CoroutineDispatcher = Dispatchers.Default
    fun io(): CoroutineDispatcher = Dispatchers.IO
    fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}

/**
 * 4/8/2020
 * comment by srdpatel: 4/8/2020 Will be used as delegated SR class to provide thread
 * <p>
 * Delegated and SR classes are useful while writing Tests through mocking it.
 * From the original author:
 * Suppose we have used Dispatchers.Main somewhere in our repository or ViewModel and now we want to
 * unit test our code on the JVM. As Dispatchers.Main is Android's MainThread, it won't be available on the JVM.
 * Hence, our test will fail.
 * The way I used it helps me to provide different configuration while testing the code and also
 * I don't have to make changes to each every place I used Dispatchers
 * </p>
 * @author srdpatel
 * @since 1.0
 */
class DefaultDispatcherProvider : DispatcherProvider