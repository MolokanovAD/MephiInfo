package ru.mephi.info

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class MephInfoApplication

fun main(args: Array<String>) {
    runApplication<MephInfoApplication>(*args)
}
