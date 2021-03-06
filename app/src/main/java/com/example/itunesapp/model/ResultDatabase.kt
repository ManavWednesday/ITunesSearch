package com.example.itunesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_items")
data class ResultDatabase(

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var amgArtistId: Int,
    var artistId: Int?,
    var artistName: String?,
    var artistViewUrl: String?,
    var artworkUrl100: String?,
    var artworkUrl30: String?,
    var artworkUrl60: String?,
    var collectionArtistId: Int?,
    var collectionArtistName: String?,
    var collectionArtistViewUrl: String?,
    var collectionCensoredName: String?,
    var collectionExplicitness: String?,
    var collectionHdPrice: Double?,
    var collectionId: Int?,
    var collectionName: String?,
    var collectionPrice: Double?,
    var collectionViewUrl: String?,
    var contentAdvisoryRating: String?,
    var copyright: String?,
    var country: String?,
    var currency: String?,
    var description: String?,
    var discCount: Int?,
    var discNumber: Int?,
    var hasITunesExtras: Boolean?,
    var isStreamable: Boolean?,
    var kind: String?,
    var longDescription: String?,
    var previewUrl: String?,
    var primaryGenreName: String?,
    var releaseDate: String?,
    var shortDescription: String?,
    var trackCensoredName: String?,
    var trackCount: Int?,
    var trackExplicitness: String?,
    var trackHdPrice: Double?,
    var trackHdRentalPrice: Double?,
    var trackId: Int?,
    var trackName: String?,
    var trackNumber: Int?,
    var trackPrice: Double?,
    var trackRentalPrice: Double?,
    var trackTimeMillis: Int?,
    var trackViewUrl: String?,
    var wrapperType: String?
)
