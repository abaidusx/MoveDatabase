package com.example.moviedatabase.network.models

data class Movie(
    val id: String,
    val primaryImage: Image,
    val titleType: TitleType,
    val titleText: Title,
    val releaseDate: ReleaseDate,
)

data class Image(val id: String, val width: Double, val height: Double, val url: String)

data class TitleType(
    val text: String,
    val id: String,
    val isSeries: Boolean,
    val isEpisode: Boolean
)

data class Title(val text: String)

data class ReleaseDate(val day: Int, val month: Int, val year: Int)
