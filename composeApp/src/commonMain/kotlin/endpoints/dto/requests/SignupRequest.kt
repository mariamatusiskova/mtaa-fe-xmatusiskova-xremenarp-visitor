package endpoints.dto.requests

import kotlinx.serialization.Serializable

/**
 * Represents a request for user signup.
 *
 * @property[username] The username chosen by the user.
 * @property[email] The email address provided by the user.
 * @property[password] The password chosen by the user.
 * @property[confirm_password] The confirmation of the password chosen by the user.
 */
@Serializable
data class SignupRequest(
    val username: String,
    val email: String,
    val password: String,
    val confirm_password: String
)