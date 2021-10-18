package com.example.itunesapp

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.itunesapp.database.DatabaseImpl
import com.example.itunesapp.network.SearchItunesApi
import com.example.itunesapp.repository.Repository
import com.example.itunesapp.viewModel.ItunesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




private fun getDatabase(context: Context): DatabaseImpl {
    return databaseBuilder(
        context,
        DatabaseImpl::class.java,
        "search_items")
        .fallbackToDestructiveMigration()
        .build()
}

private const val BASE_URL = "https://itunes.apple.com"
private fun getRemoteApi(): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
}
val remoteApiModule  = module {
    single {
        getRemoteApi()
    }
    single {
        get<Retrofit>().create(SearchItunesApi::class.java)
    }
}

val databaseModule = module {
    single {
        getDatabase(get())
    }
}



val repository = module {
    single {
        Repository(get(),get(),get())
    }
}
val viewModel = module {
    viewModel {
        ItunesViewModel(get())
    }
}
