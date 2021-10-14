package com.example.itunesapp.repositoryMapping


interface ResultMapping<Result,ResultDatabase> {

    suspend fun mapResults(result: Result) : ResultDatabase

}