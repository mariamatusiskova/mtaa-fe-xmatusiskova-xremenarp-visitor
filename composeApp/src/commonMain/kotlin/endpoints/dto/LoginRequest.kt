package endpoints.dto

import kotlinx.serialization.Serializable

@Serializable
class LoginRequest (
    val username: String,
    val password: String
)