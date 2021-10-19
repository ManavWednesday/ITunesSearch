package com.example.itunesapp.mapper


interface ResultMapping<Result,ResultDatabase> {

    suspend fun mapResults(result: Result) : ResultDatabase

}