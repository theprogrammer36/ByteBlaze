package com.example.byteblaze.domain.model

import java.time.ZonedDateTime

data class NewsArticle(
    val id: String,
    val title: String,
    val section: String,
    val publicationDate: ZonedDateTime,
    val author: String,
    val thumbnailUrl: String?,
    val summary: String,
    val bodyHtml: String?,
    val webUrl: String
)