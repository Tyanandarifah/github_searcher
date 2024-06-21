package com.iglo.githubsearcher

import okhttp3.RequestBody
import retrofit2.Retrofit
import javax.inject.Inject

class UserServiceImpl @Inject constructor(private val retrofit: Retrofit) : UsersService {
    override suspend fun getUsers(): ApiResponse<List<UsersModel>> {
        val api = retrofit.create(UsersService::class.java)
//        try {
//            val response = api.getUsers()
//            return ApiResponse.success(response)
//        } catch (e: Exception) {
//            return ApiResponse.error(e)
//        }
    }
}