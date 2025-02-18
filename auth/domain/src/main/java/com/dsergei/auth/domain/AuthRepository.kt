package com.dsergei.auth.domain

import com.dsergei.core.domain.util.DataError
import com.dsergei.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}