package me.personal.keycloakkotlin.config

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder
import org.keycloak.OAuth2Constants
import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.KeycloakBuilder

private object KeycloakProperties {
    const val serverUrl = "http://localhost:8080/auth"
    const val realm = "master"
    const val clientId = "admin-cli"
    const val userName = "admin"
    const val password = "admin"
}


object KeycloakConfig {

    private var keycloak: Keycloak? = null

    private fun buildKeycloakInstance(): Keycloak = KeycloakBuilder.builder()
        .serverUrl(KeycloakProperties.serverUrl)
        .realm(KeycloakProperties.realm)
        .grantType(OAuth2Constants.PASSWORD)
        .username(KeycloakProperties.userName)
        .password(KeycloakProperties.password)
        .clientId(KeycloakProperties.clientId)
        .resteasyClient(
            ResteasyClientBuilder()
                .connectionPoolSize(10)
                .build()
        )
        .build()


    fun keycloakInstance(): Keycloak {
        if (keycloak == null) {
            keycloak = buildKeycloakInstance()
        }
        return keycloak as Keycloak
    }
}