package com.example.chatgptapp.models

import com.google.gson.annotations.SerializedName

data class ChatResponse(
    @SerializedName("choices")
    val choices: List<ChatChoice>
)
