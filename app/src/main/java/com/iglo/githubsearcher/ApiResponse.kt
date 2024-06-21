package com.iglo.githubsearcher

import okhttp3.ResponseBody

sealed class ApiResponse<T : Any?>(val state : Int = 2, val data : (T)?) {
    companion object {
        fun <T> success(t : T) = ResponseSuccess(t)
        fun <T> error(error : Exception?) = ResponseError<T>(error, null, 0)
        fun <T> error(error : Exception?, body: ResponseBody?, code: Int) = ResponseError<T>(error, body, code)
        fun <T> loading() = ResponseLoading<T>()
        const val SUCCESS = 0
        const val ERROR = 1
        const val LOADING = 2
    }
}

class ResponseSuccess<T>(data : T) : ApiResponse<T>(0, data)
data class ResponseError<T>(val error : Exception?, val body: ResponseBody?, val code: Int) : ApiResponse<T>(1,null)
class ResponseLoading<T> : ApiResponse<T>(2,null)