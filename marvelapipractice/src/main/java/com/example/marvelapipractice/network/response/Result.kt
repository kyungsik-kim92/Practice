package com.example.marvelapipractice.network.response


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("result")
data class Result(
    @Embedded
    @SerializedName("comics")
    val comics: Comics,
    @SerializedName("description")
    val description: String,
    @Embedded
    @SerializedName("events")
    val events: Events,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @Embedded
    @SerializedName("series")
    val series: Series,
    @Embedded
    @SerializedName("stories")
    val stories: Stories,
    @Embedded
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("urls")
    val urls: List<Url>
) {
    fun getSummary(): String =
        """
            Url : ${urls.size} Events : ${events.available} Comics : ${comics.available}
            Stories : ${stories.available} Series : ${series.available}
        """.trimIndent()
}