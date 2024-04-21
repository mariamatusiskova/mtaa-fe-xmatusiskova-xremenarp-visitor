package endpoints.dto

import kotlinx.serialization.Serializable

@Serializable
data class DetailResponse(
    val detail: String
)
