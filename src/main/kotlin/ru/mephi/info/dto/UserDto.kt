package ru.mephi.info.dto

data class UserDto(
    val id: Int? = null,
    val name: String,
    val lastname: String,
    val groupId: String? = null,
    val email: String,
    val password: String,
    val login: String,
)