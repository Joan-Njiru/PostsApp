package dev.joan.postapp.repository

import dev.joan.postapp.api.ApiClient
import dev.joan.postapp.api.ApiInterface
import dev.joan.postapp.model.PostsDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class PostsRepo {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun getPosts(): Response<PostsDetails> {
        return withContext(Dispatchers.IO){apiClient.getPosts()
        }
    }
}