package me.personal.keycloakkotlin.controller

import me.personal.keycloakkotlin.dto.LoginRequest
import me.personal.keycloakkotlin.dto.User
import me.personal.keycloakkotlin.service.KeycloakAdminClientService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api")
@RestController
class UserController(val keycloakAdminClientService: KeycloakAdminClientService) {

    @PostMapping("/save")
    fun createUser(@RequestBody user: User): String {
        println("saving.....")
        return keycloakAdminClientService.addUser(user)
    }

    @PostMapping("/token")
    fun getToken(@RequestBody request: LoginRequest): ResponseEntity<*> {
        return ResponseEntity.ok(keycloakAdminClientService.getAccessToken(request))
    }

    @GetMapping("/sessions")
    fun getOpenSessions(@RequestParam userId: String): ResponseEntity<*> {
        return ResponseEntity.ok(keycloakAdminClientService.getOpenSessions(userId))
    }

    @GetMapping("/logout")
    fun closeOpenSessions(@RequestParam userId: String): ResponseEntity<*> {
        return ResponseEntity.ok(keycloakAdminClientService.closeOpenSessions(userId))
    }
}