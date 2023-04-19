package com.example.sweetheart.ui.usecases


class ValidateRepeatPassword {
    fun execute(password: String, repeatPassword: String): ValidationResult {
        if (password != repeatPassword) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password must be at least 8 characters"
            )
        }

        val containsLettersAndDigits = password.any{ it.isDigit() } && password.any{ it.isLetter() }

        if (!containsLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to contain at least one letter and digit"
            )
        }

        return ValidationResult(successful = true)
    }
}