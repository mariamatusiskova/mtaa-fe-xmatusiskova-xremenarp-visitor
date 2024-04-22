package endpoints.dto.requests

import kotlinx.serialization.Serializable

@Serializable
data class EditUsernameRequest(val username: String)

@Serializable
data class EditEmailRequest(val email: String)

@Serializable
data class EditPasswordRequest(val password: String, val confirm_password: String)
