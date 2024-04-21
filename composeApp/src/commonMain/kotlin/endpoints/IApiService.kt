package endpoints

import endpoints.dto.PostRequest
import endpoints.dto.PostResponse

interface IApiService {
    suspend fun getPosts(): List<PostResponse>
    suspend fun createPost(postRequest: PostRequest): PostResponse? // could be null in case sth goes wrong
}