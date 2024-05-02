package endpoints.dto.requests

import kotlinx.serialization.Serializable

/**
 * Represents a request to edit a username.
 * @property[username] The new username.
 */
@Serializable
data class EditUsernameRequest(val username: String)

/**
 * Represents a request to edit an email address.
 * @property[email] The new email address.
 */
@Serializable
data class EditEmailRequest(val email: String)

/**
 * Represents a request to edit a password.
 * @property[password] The new password.
 * @property[confirm_password] The confirmation of the new password.
 */
@Serializable
data class EditPasswordRequest(val password: String, val confirm_password: String)
