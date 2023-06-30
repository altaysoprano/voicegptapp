package com.example.chatgptapp.models

import com.google.gson.annotations.SerializedName

data class ChatChoice(
    @SerializedName("message")
    val message: ChatMessage
)
