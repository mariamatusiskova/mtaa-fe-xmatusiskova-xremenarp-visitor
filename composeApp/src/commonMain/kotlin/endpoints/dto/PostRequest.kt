package endpoints.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val username: String,
    val email: String,
    val password: String,
    val confirm_password: String
)