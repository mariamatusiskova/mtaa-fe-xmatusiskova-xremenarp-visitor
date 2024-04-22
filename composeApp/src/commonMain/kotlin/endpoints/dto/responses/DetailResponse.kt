package endpoints.dto.responses

import kotlinx.serialization.Serializable

@Serializable
data class DetailResponse(
    val detail: String
)
