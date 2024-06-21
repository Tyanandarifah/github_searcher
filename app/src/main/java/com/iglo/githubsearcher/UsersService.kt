package com.iglo.githubsearcher

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface UsersService {
    @GET("users")
    suspend fun getUsers(): ApiResponse<List<UsersModel>>
}