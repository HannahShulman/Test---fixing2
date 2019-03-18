/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cheetah.test.testing

import android.os.Handler
import android.os.Looper
import com.cheetah.test.testing.util.AppExecutorConstants

import java.util.concurrent.Executor
import java.util.concurrent.Executors


/**
 This class is responsible for holding different
 thread types to give us a choice on with thread we'd like to work on.
 */


open class AppExecutors(
    private val diskIO: Executor,
    private val networkIO: Executor,
    private val mainThread: Executor = AppExecutors.MainThreadExecutor())
{
    constructor() : this(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(AppExecutorConstants.nThreads),
        MainThreadExecutor()
    )

    fun diskIO(): Executor {
        return diskIO
    }

    fun networkIO(): Executor {
        return networkIO
    }

    fun mainThread(): Executor {
        return mainThread
    }

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}
