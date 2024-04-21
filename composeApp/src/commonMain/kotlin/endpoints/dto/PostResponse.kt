package endpoints.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val detail: String
)
