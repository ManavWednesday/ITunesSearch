package com.example.itunesapp.mapper


import com.example.itunesapp.model.RemoteDataModel
import com.example.itunesapp.model.ResultDatabase

class ResultMappingImpl:ResultMapping<RemoteDataModel,ResultDatabase> {
    override suspend fun mapResults(result: RemoteDataModel):ResultDatabase {

        return ResultDatabase(
        amgArtistId = result.amgArtistId,
        artistId = result.artistId,
        artistName = result.artistName,
        artistViewUrl = result.artistViewUrl,
        artworkUrl100 = result.artworkUrl100,
        artworkUrl30 = result.artworkUrl30,
        artworkUrl60 = result.artworkUrl60,
        collectionArtistId = result.collectionArtistId,
        collectionArtistName = result.collectionArtistName,
        collectionArtistViewUrl = result.collectionArtistViewUrl,
        collectionCensoredName = result.collectionCensoredName,
        collectionExplicitness = result.collectionExplicitness,
        collectionHdPrice = result.collectionHdPrice,
        collectionId = result.collectionId,
        collectionName = result.collectionName,
        collectionPrice = result.collectionPrice,
        collectionViewUrl = result.collectionViewUrl,
        contentAdvisoryRating = result.contentAdvisoryRating,
        copyright = result.copyright,
        country = result.country,
        currency = result.currency,
        description = result.description,
        discCount = result.discCount,
        discNumber = result.discNumber,
        hasITunesExtras = result.hasITunesExtras,
        isStreamable = result.isStreamable,
        kind = result.kind,
        longDescription = result.longDescription,
        previewUrl = result.previewUrl,
        primaryGenreName = result.primaryGenreName,
        releaseDate = result.releaseDate,
        shortDescription = result.shortDescription,
        trackCensoredName = result.trackCensoredName,
        trackCount = result.trackCount,
        trackExplicitness = result.trackExplicitness,
        trackHdPrice = result.trackHdPrice,
        trackHdRentalPrice = result.trackHdRentalPrice,
        trackId = result.trackId,
        trackName = result.trackName,
        trackNumber = result.trackNumber,
        trackPrice = result.trackPrice,
        trackRentalPrice =result.trackRentalPrice,
        trackTimeMillis = result.trackTimeMillis,
        trackViewUrl = result.trackViewUrl,
        wrapperType = result.wrapperType,
        )

    }

    suspend fun searchList(searchList:List<RemoteDataModel>): List<ResultDatabase>{
        return searchList.map { mapResults(it) }
    }


}