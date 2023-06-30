package com.example.chatgptapp.models

import com.google.gson.annotations.SerializedName

data class ChatMessage(
    @SerializedName("role")
    val role: String,
    @SerializedName("content")
    val content: String
)
