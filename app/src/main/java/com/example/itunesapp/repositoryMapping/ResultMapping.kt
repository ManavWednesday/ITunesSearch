package com.example.itunesapp.repositoryMapping


interface ResultMapping<Result,ResultDatabase> {

    suspend fun mapResults(result: Result) : ResultDatabase

    suspend fun mapResults(result:List<Result>) : List<ResultDatabase> = result.map{ mapResults(it) }


}