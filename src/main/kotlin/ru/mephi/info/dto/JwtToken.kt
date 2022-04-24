package ru.mephi.info.dto

data class JwtToken(private val token: String){
    fun getToken() = token
}