package com.example.chatgptapp.models

import com.google.gson.annotations.SerializedName

data class ChatRequest(
    @SerializedName("messages")
    val messages: List<ChatMessage>
)
