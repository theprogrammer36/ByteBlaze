package com.example.byteblaze.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuardianApiResponse(
    val response: GuardianResponse
)

@Serializable
data class GuardianResponse(
    val status: String,
    val userTier: String,
    val total: Int,
    val startIndex: Int,
    val pageSize: Int,
    val currentPage: Int,
    val pages: Int,
    val orderBy: String,
    val results: List<Article>
)

@Serializable
data class Article(
    val id: String,
    val type: String,
    val sectionId: String,
    val sectionName: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String,
    val apiUrl: String,
    val fields: ArticleFields? = null
)

@Serializable
data class ArticleFields(
    val headline: String? = null,
    val standfirst: String? = null,
    val trailText: String? = null,
    val byline: String? = null,
    val main: String? = null,
    val body: String? = null,
    val wordcount: String? = null,
    val firstPublicationDate: String? = null,
    @SerialName("isInappropriateForSponsorship")
    val isInappropriateForSponsorship: String? = null,
    @SerialName("isPremoderated")
    val isPremoderated: String? = null,
    val lastModified: String? = null,
    val productionOffice: String? = null,
    val publication: String? = null,
    val shortUrl: String? = null,
    @SerialName("shouldHideAdverts")
    val shouldHideAdverts: String? = null,
    @SerialName("showInRelatedContent")
    val showInRelatedContent: String? = null,
    val thumbnail: String? = null,
    @SerialName("legallySensitive")
    val legallySensitive: String? = null,
    val lang: String? = null,
    @SerialName("isLive")
    val isLive: String? = null,
    val bodyText: String? = null
)