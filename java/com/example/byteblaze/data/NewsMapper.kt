package com.example.byteblaze.data


import com.example.byteblaze.data.model.Article
import com.example.byteblaze.domain.model.NewsArticle
import java.time.ZonedDateTime

fun Article.toDomain(): NewsArticle {
    return NewsArticle(
        id = id,
        title = fields?.headline ?: webTitle,
        section = sectionName,
        publicationDate = ZonedDateTime.parse(webPublicationDate),
        author = fields?.byline ?: "",
        thumbnailUrl = fields?.thumbnail,
        summary = fields?.trailText ?: "",
        bodyHtml = fields?.body,
        webUrl = webUrl
    )
}