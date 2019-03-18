package com.cheetah.test.testing.koin.modules

import android.util.Log
import androidx.room.Room
import com.cheetah.test.testing.AppExecutors
import com.cheetah.test.testing.api.APIConfiguration
import com.cheetah.test.testing.api.CustomerCartApi
import com.cheetah.test.testing.koin.modules.DataSourceProperties.CONNECT_TIMEOUT
import com.cheetah.test.testing.koin.modules.DataSourceProperties.READ_TIMEOUT
import com.cheetah.test.testing.koin.modules.DataSourceProperties.WRITE_TIMEOUT
import com.cheetah.test.testing.roomdb.RoomDB
import com.cheetah.test.testing.util.LiveDataCallAdapterFactory
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


object DataSourceProperties {
    const val CONNECT_TIMEOUT = "CONNECT_TIMEOUT"
    const val READ_TIMEOUT = "READ_TIMEOUT"
    const val WRITE_TIMEOUT = "WRITE_TIMEOUT"
}

/**
 * This module is responsible for init the objects regarding the local storage.
 */

val storageModule = module {

    single{
        Room.databaseBuilder(get(), RoomDB::class.java, "cart_info.db")
            .fallbackToDestructiveMigration().build()
    }


    single<AppExecutors> { AppExecutors(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1))
    }
}


/**
 * This module is responsible for init. the objects regarding the networking
 */

val netModule = module {

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .baseUrl(APIConfiguration.API_URL)
            .build()
    }

    factory {
        OkHttpClient.Builder()
            .connectTimeout(APIConfiguration.TIMEOUT_IN_SEC.toLong(), TimeUnit.SECONDS)
            .writeTimeout(APIConfiguration.TIMEOUT_IN_SEC.toLong(), TimeUnit.SECONDS)
            .readTimeout(APIConfiguration.TIMEOUT_IN_SEC.toLong(), TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(get())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build() as OkHttpClient
    }

    factory {
        HttpLoggingInterceptor { message -> Log.d("Message", message) }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    factory { (get() as Retrofit).create(CustomerCartApi::class.java) as CustomerCartApi }


    factory {
        Interceptor {chain->
            val request = chain.request()

            val builder = request.newBuilder()
            var connectTimeout = chain.connectTimeoutMillis()
            var readTimeout = chain.readTimeoutMillis()
            var writeTimeout = chain.writeTimeoutMillis()

            val connectNew = request.header(CONNECT_TIMEOUT)
            val readNew = request.header(READ_TIMEOUT)
            val writeNew = request.header(WRITE_TIMEOUT)

            if (!connectNew.isNullOrEmpty()) connectTimeout = Integer.valueOf(connectNew)
            if (!readNew.isNullOrEmpty()) readTimeout = Integer.valueOf(readNew)
            if (!writeNew.isNullOrEmpty()) writeTimeout = Integer.valueOf(writeNew)

            return@Interceptor chain
                .withConnectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .withReadTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .withWriteTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                .proceed(builder.build())
        }
    }


    factory {
        GsonConverterFactory.create(
            GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().create())
                as Converter.Factory
    }

}



