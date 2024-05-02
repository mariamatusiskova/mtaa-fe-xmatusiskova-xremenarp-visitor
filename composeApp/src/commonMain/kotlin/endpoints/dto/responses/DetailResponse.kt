package endpoints.dto.responses

import kotlinx.serialization.Serializable

/**
 * Represents a response containing a detail message from HTTP Response.
 * @property[detail] The detail message contained in the response.
 */
@Serializable
data class DetailResponse(
    val detail: String
)
