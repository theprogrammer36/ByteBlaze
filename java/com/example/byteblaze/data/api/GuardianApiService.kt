package com.example.byteblaze.data.api

import com.example.byteblaze.data.model.GuardianApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GuardianApiService {

    @GET("search")
    suspend fun getArticles(
        @Query("api-key") apiKey: String,
        @Query("page") page: Int = 1,
        @Query("page-size") pageSize: Int = 20,
        @Query("show-fields") fields: String = "headline,standfirst,trailText,byline,main,body,wordcount,firstPublicationDate,lastModified,thumbnail,bodyText",
        @Query("order-by") orderBy: String = "newest"
    ): GuardianApiResponse

    @GET("search")
    suspend fun getArticlesBySection(
        @Query("api-key") apiKey: String,
        @Query("section") section: String,
        @Query("page") page: Int = 1,
        @Query("page-size") pageSize: Int = 20,
        @Query("show-fields") fields: String = "headline,standfirst,trailText,byline,main,body,wordcount,firstPublicationDate,lastModified,thumbnail,bodyText",
        @Query("order-by") orderBy: String = "newest"
    ): GuardianApiResponse

    @GET("search")
    suspend fun searchArticles(
        @Query("api-key") apiKey: String,
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("page-size") pageSize: Int = 20,
        @Query("show-fields") fields: String = "headline,standfirst,trailText,byline,main,body,wordcount,firstPublicationDate,lastModified,thumbnail,bodyText",
        @Query("order-by") orderBy: String = "relevance"
    ): GuardianApiResponse
}