package com.example.itunesapp

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.itunesapp.database.SongDescriptionDao
import com.example.itunesapp.database.SongDescriptionImpl
import com.example.itunesapp.network.SearchItunesApi
import com.example.itunesapp.repository.Repository
import com.example.itunesapp.viewModel.ItunesViewModel
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





private fun getSongDescriptionDatabase(context: Context): SongDescriptionImpl {
    return databaseBuilder(
        context,
        SongDescriptionImpl::class.java,
        "song_description")
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
        getSongDescriptionDatabase(get()).songDescriptionDao()
    }
}

val repository = module {
    single {
        Repository(get(), get())
    }
}
@FlowPreview
val viewModel = module {
    viewModel {
        ItunesViewModel(get())
    }
}
