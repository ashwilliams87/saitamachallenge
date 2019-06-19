package com.ashwilliams87.saitamachallenge.helper

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ashwilliams87.saitamachallenge.intarfaces.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository : Application() {
    private var retrofit: Retrofit? = null

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
            .baseUrl("http://oplotbot.ashwilliams.tk") //Базовая часть адреса
            //   .addConverterFactory(createGsonConverter())
            .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
            .build()

        api = retrofit!!.create<Api>(Api::class.java!!) //Создаем объект, при помощи которого будем выполнять запросы

        roomDb = Room.databaseBuilder(this.applicationContext, SaitamaDataBase::class.java, "saitama")
            // allow queries on the main thread.
            // Don't do this on a real app! See PersistenceBasicSample for an example.
            .allowMainThreadQueries()
            .build()

        
    }

//    private fun createGsonConverter(): Converter.Factory {
//        val gsonBuilder = GsonBuilder()
//        gsonBuilder.registerTypeAdapter(Tasks::class.java, RatesDeserializer())
//        val gson = gsonBuilder.create()
//        return GsonConverterFactory.create(gson)
//    }

    companion object {
        var api: Api? = null
            private set
        var roomDb: SaitamaDataBase? = null
            private set

    }


}