package me.personal.keycloakkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KeycloakKotlinApplication

fun main(args: Array<String>) {
    runApplication<KeycloakKotlinApplication>(*args)
}
