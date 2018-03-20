package hu.bme.aut.stewe.rebrickableclient.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.LegoApi
import hu.bme.aut.stewe.rebrickableclient.network.swagger.api.UsersApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideGson() = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson) =
            Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build()

    @Provides
    @Singleton
    fun provideUsersApi(retrofit: Retrofit) = retrofit.create(UsersApi::class.java)

    @Provides
    @Singleton
    fun provideLegoApi(retrofit: Retrofit) = retrofit.create(LegoApi::class.java)
}