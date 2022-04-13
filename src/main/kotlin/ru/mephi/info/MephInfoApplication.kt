package ru.mephi.info

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MephInfoApplication

fun main(args: Array<String>) {
    runApplication<MephInfoApplication>(*args)
}
