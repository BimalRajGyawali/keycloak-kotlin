package me.personal.keycloakkotlin.service

import me.personal.keycloakkotlin.config.KeycloakConfig
import me.personal.keycloakkotlin.dto.LoginRequest
import me.personal.keycloakkotlin.dto.User
import org.keycloak.authorization.client.AuthzClient
import org.keycloak.authorization.client.Configuration
import org.keycloak.representations.AccessTokenResponse
import org.keycloak.representations.idm.CredentialRepresentation
import org.keycloak.representations.idm.UserRepresentation
import org.springframework.stereotype.Service

@Service
class KeycloakAdminClientService {

    fun addUser(user: User): String {
        println("Adding")
        println(KeycloakConfig.keycloakInstance())
        val usersResource = KeycloakConfig.keycloakInstance().realm("First").users()

        val kcUser = UserRepresentation()

        kcUser.apply {
            username = user.username
            firstName = user.firstName
            lastName = user.lastName
            email = user.email
            isEnabled = true
            isEmailVerified = false
            credentials = listOf(createPasswordCredentials(user.password))
            attributes = mapOf(
                Pair("accountNumber", listOf(user.accountNumber))
            )
        }

        val response = usersResource.create(kcUser)

        return if (response.status == 409) "Already exists" else "Success"
    }


    fun getAccessToken(request: LoginRequest): AccessTokenResponse {
        val config = Configuration(
            "http://localhost:8080/auth",
            "First", "springboot",
            mapOf(Pair("secret", ""), Pair("grant_type", "password")), null
        )
        val authClient = AuthzClient.create(config)
        return authClient.obtainAccessToken(request.username, request.password)
    }

    fun getOpenSessions(userId: String): Any {
        return KeycloakConfig.keycloakInstance()
            .realm("First")
            .users().get(userId).userSessions
    }

    fun closeOpenSessions(userId: String): String {
        KeycloakConfig.keycloakInstance()
            .realm("First")
            .users().get(userId).logout()

        return "Success"
    }

    companion object {
        private fun createPasswordCredentials(password: String): CredentialRepresentation {
            val passwordCredentials = CredentialRepresentation()
            passwordCredentials.isTemporary = false
            passwordCredentials.type = CredentialRepresentation.PASSWORD
            passwordCredentials.value = password
            return passwordCredentials
        }
    }
}