package endpoints

object HttpRoutes {

    private const val API_BASE_URL = "http://10.0.2.2:8000" // on emulator
    //private const val API_BASE_URL = "http://10.10.40.110:8000" // on device (your IP address)
    const val SIGNUP_POST = "$API_BASE_URL/api/signup/"
    const val LOGIN_POST = "$API_BASE_URL/api/login/"
}

// 58367