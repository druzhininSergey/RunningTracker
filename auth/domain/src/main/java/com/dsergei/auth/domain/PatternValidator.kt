package com.dsergei.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}