package com.example.chatgptapp

import com.example.chatgptapp.models.ChatRequest
import com.example.chatgptapp.models.ChatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("chat/completions") // API'nin tam URL'si buraya eklenir
    fun getChatCompletion(@Body request: ChatRequest): Call<ChatResponse>
}
