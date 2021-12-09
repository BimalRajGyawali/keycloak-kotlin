package me.personal.keycloakkotlin.dto

data class User(
    val username:String,
    val firstName:String,
    val lastName:String,
    val email:String,
    val password: String,
    val accountNumber:String
)

data class LoginRequest(
    val username: String,
    val password: String
)
