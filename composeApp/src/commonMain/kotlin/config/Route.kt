package config

sealed class Route(val route: String) {
    object Login: Route("Log in")
    object Signup: Route("Sign up")
}