package com.dsergei.auth.data

import com.dsergei.auth.domain.AuthRepository
import com.dsergei.core.data.networking.post
import com.dsergei.core.domain.util.DataError
import com.dsergei.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
) : AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}